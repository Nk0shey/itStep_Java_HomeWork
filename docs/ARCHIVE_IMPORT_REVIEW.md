# Archive import review — 2026-11-04

Compared exam.zip and microservices-store.zip with the existing Java Lessons and Homework checkouts. None of their 15 Java files matched existing Java sources. HomeWork main was verified at 6c4d3a92d141814ed51dbfd07843b216c72adfd1 before import.

## Changes

- Imported both as independent Java 21 projects, outside the existing Java 17 Maven reactor.
- Excluded macOS metadata, IDE state, Gradle caches and compiled files.
- Exam: reject blank/missing email, configure upstream URL and connection/read timeouts, return 502 on upstream failure, pin the Gradle distribution checksum, and replace the empty context test with behavioral tests.
- Store: repaired the build and completed product CRUD/search, transactional inventory reservations, and a separate HTTP order service. Orders retain decimal price snapshots, require UUID idempotency keys and survive restarts using separate H2 databases. Added concurrency and failure/retry coverage.

## Validation

- Exam: Gradle 8.14.3 `test bootJar` passed, 6 tests, zero failures/errors/skips.
- Store: Maven 3.9.9 `clean verify` and final `verify` passed for both services: 5 product tests and 6 order tests, zero failures/errors/skips. Product tests cover CRUD/search/validation, price snapshots, oversell prevention and concurrent idempotent retries; order tests cover creation/replay, upstream errors and recovery after a failed database save.
- Existing HomeWork reactor: all 18 modules built and all 77 tests passed.
- Launched both packaged applications using JDK 21.0.8. Exam HTTP checks passed for valid user (200), blank email (400), posts returned by a local upstream (200), disabled email endpoint (200), and unavailable upstream (502). The actual PostClient HTTP/JSON path was exercised against that local upstream.
- Store packaged-JAR HTTP validation is reproducible with `python3 microservices-store/scripts/smoke.py`: real checkout, stock errors, idempotent replay, price snapshots, both-service database restart, product-service outage/recovery and historical orders after deletion. A precision mismatch on order timestamps found by this test was corrected. Validation processes are stopped automatically.

## Limits

The live JSONPlaceholder service was not tested. Tests use a local HTTP stub or mocks. Email is only logged, not sent. User records are not persisted. Store scope is one product per order and one order-service instance. Authentication, payment, cancellation and automatic abandoned-reservation reconciliation are outside this local learning application. No database credentials or real email addresses are required for these checks.
