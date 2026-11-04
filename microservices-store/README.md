# Microservices store

A Java 21 / Spring Boot 3.5.3 learning application with two independently running services and separate databases.

- **product-service**, port 8081: product CRUD, paginated case-insensitive name search, and transactional inventory reservations.
- **order-service**, port 8082: create, list and fetch orders. Each order contains one product and its quantity, with a name/price snapshot and calculated total. It calls product-service over HTTP.

## Build and run

Requires JDK 21 and Maven 3.9+:

```sh
mvn clean verify
```

From this directory, start each service in a separate terminal:

```sh
java -jar product-service/target/product-service-0.0.1-SNAPSHOT.jar
java -jar order-service/target/order-service-0.0.1-SNAPSHOT.jar
```

H2 databases persist under `./data/` relative to the process working directory. They are ignored by Git. Stop services before deleting those files to reset the demo. Override `spring.datasource.url`, `server.port` and order-service's `products.url` through standard Spring configuration as needed. No credentials are needed for the default local databases.

## Example

```sh
curl -i http://localhost:8081/products -H 'Content-Type: application/json' \
  -d '{"name":"Book","price":12.50,"stock":3}'
# Use the returned product id below (1 on a fresh database).
curl -i http://localhost:8082/orders -H 'Content-Type: application/json' \
  -H 'Idempotency-Key: 9b4c90c4-5072-4214-b758-cd653f39fb7c' \
  -d '{"productId":1,"quantity":2}'
curl 'http://localhost:8081/products?q=book&page=0&size=20'
curl http://localhost:8082/orders
```

Use a new UUID key for each new order; reuse the same key **and body** on retries. A successful order returns 200 and its stable UUID. Replays return the saved order without deducting stock again. Reusing a key with different input returns 409. Missing/invalid headers and invalid quantities return 400; missing products/orders return 404, insufficient stock returns 409, and an unavailable product-service returns 503. Money uses decimal arithmetic and a maximum of two fractional digits.

Product routes: `POST /products` (201), `GET /products`, `GET /products/{id}`, `PUT /products/{id}`, `DELETE /products/{id}` (204). Create/update body contains `name`, `price` and `stock`. List responses are Spring Data pages, with `content` and `totalElements`; page sizes are 1–100.

Internal route `POST /products/reservations/{uuid}` accepts `productId` and `quantity`. It locks the product row, verifies stock and stores the reservation and deduction in one transaction. A retry returns the original reservation and price snapshot. If the order database fails after the reservation commits, retrying the same order key recovers it without another deduction. Keep both service databases together when retaining this relationship.

## Validation

```sh
mvn verify
python3 scripts/smoke.py
```

The smoke test starts the packaged JARs on temporary ports with disposable databases, tests checkout/replays/validation/stock errors, restarts both services to verify persistence, simulates product-service downtime, retries after recovery and checks historical orders after deleting a product. It stops its processes and removes its data. Python 3 standard library and Java 21 are sufficient.

JUnit tests cover CRUD/search, invalid input, concurrent oversell prevention, concurrent idempotent reservations, price snapshots, order replay, service failures and recovery after a local save failure.

## Scope

This is a local learning application: one order-service instance, one product per order, no authentication, payment, cancellation or shipping. Orders are immutable. A reservation left by an interrupted checkout is recovered by retrying the same key; automatic expiration/reconciliation is outside this implementation. The product database is the source of truth for stock. Administrative stock updates replace its current value. Do not expose these unauthenticated administrative APIs publicly.

The original archive's empty product classes and missing order service have been implemented. macOS/IDE metadata, build outputs and caches are excluded.
