"""Run after mvn verify. Uses disposable databases and shuts down its processes."""
import json
import os
from pathlib import Path
import shutil
import socket
import subprocess
import tempfile
import time
import urllib.error
import urllib.request
import uuid

ROOT = Path(__file__).resolve().parents[1]
JAVA = str(Path(os.environ['JAVA_HOME']) / 'bin/java') if os.environ.get('JAVA_HOME') else shutil.which('java')
HTTP = urllib.request.build_opener(urllib.request.ProxyHandler({}))

def free_port():
    with socket.socket() as sock:
        sock.bind(('127.0.0.1', 0))
        return sock.getsockname()[1]

def request(port, path, data=None, key=None, method=None):
    headers = {'Content-Type': 'application/json'}
    if key:
        headers['Idempotency-Key'] = key
    req = urllib.request.Request(f'http://127.0.0.1:{port}{path}',
        data=json.dumps(data).encode() if data is not None else None,
        headers=headers, method=method)
    try:
        with HTTP.open(req, timeout=12) as response:
            body = response.read()
            return response.status, json.loads(body) if body else None
    except urllib.error.HTTPError as error:
        return error.code, error.read().decode()

with tempfile.TemporaryDirectory(prefix='store-smoke-') as temp:
    processes = {}
    logs = []
    pp, op = free_port(), free_port()
    def start(module, port):
        jar = ROOT / module / 'target' / f'{module}-0.0.1-SNAPSHOT.jar'
        log = open(Path(temp) / f'{module}.log', 'a+')
        logs.append(log)
        proc = subprocess.Popen([JAVA, '-jar', str(jar), f'--server.port={port}',
            f'--products.url=http://127.0.0.1:{pp}',
            f'--spring.datasource.url=jdbc:h2:file:{temp}/{module}'],
            cwd=temp, stdout=log, stderr=subprocess.STDOUT)
        processes[module] = proc
        for _ in range(120):
            if proc.poll() is not None:
                log.seek(0)
                raise RuntimeError(log.read())
            try:
                status, _ = request(port, '/products' if module == 'product-service' else '/orders')
                if status == 200:
                    return
            except OSError:
                pass
            time.sleep(.25)
        raise RuntimeError(f'{module} did not become ready')

    def stop(module):
        proc = processes.pop(module, None)
        if proc is not None:
            proc.terminate()
            try:
                proc.wait(timeout=15)
            except subprocess.TimeoutExpired:
                proc.kill()
                proc.wait()

    try:
        start('product-service', pp)
        start('order-service', op)
        status, p = request(pp, '/products', {'name': 'Book', 'price': 12.50, 'stock': 3})
        assert status == 201, (status, p)
        pid = p['id']
        body = {'productId': pid, 'quantity': 2}
        key = str(uuid.uuid4())
        status, order = request(op, '/orders', body, key)
        assert status == 200 and order['total'] == 25, (status, order)
        assert request(op, '/orders', body, key)[1] == order
        assert request(pp, f'/products/{pid}')[1]['stock'] == 1
        assert request(op, '/orders', {'productId': pid, 'quantity': 3}, key)[0] == 409
        assert request(op, '/orders', body, str(uuid.uuid4()))[0] == 409
        assert request(op, '/orders', {'productId': pid, 'quantity': 0}, str(uuid.uuid4()))[0] == 400
        assert request(op, '/orders', body)[0] == 400
        assert request(op, '/orders', {'productId': 99999, 'quantity': 1}, str(uuid.uuid4()))[0] == 404
        assert request(pp, f'/products/{pid}', {'name': 'New title', 'price': 20, 'stock': 1}, method='PUT')[0] == 200
        assert request(op, f'/orders/{key}')[1]['total'] == 25
        stop('order-service'); stop('product-service')
        start('product-service', pp); start('order-service', op)
        assert request(op, '/orders', body, key)[1]['total'] == 25
        assert request(pp, f'/products/{pid}')[1]['stock'] == 1
        stop('product-service')
        retry_key = str(uuid.uuid4())
        retry_body = {'productId': pid, 'quantity': 1}
        assert request(op, '/orders', retry_body, retry_key)[0] == 503
        assert request(op, '/orders')[1]['totalElements'] == 1
        start('product-service', pp)
        status, new_order = request(op, '/orders', retry_body, retry_key)
        assert status == 200 and new_order['total'] == 20, (status, new_order)
        assert request(pp, f'/products/{pid}')[1]['stock'] == 0
        assert request(pp, f'/products/{pid}', method='DELETE')[0] == 204
        assert request(op, f'/orders/{key}')[1]['productName'] == 'Book'
        print('PASS: real two-service checkout, validation, stock conflicts, idempotent replay, price snapshots, database restart persistence, outage recovery and product deletion')
    finally:
        for module in list(processes):
            stop(module)
        for log in logs:
            log.close()
