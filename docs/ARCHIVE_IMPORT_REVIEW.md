# Archive import review — 2026-11-04

Compared exam.zip and microservices-store.zip with the existing Java Lessons and Homework checkouts. None of their 15 Java files matched existing Java sources. HomeWork main was verified at 6c4d3a92d141814ed51dbfd07843b216c72adfd1 before import.

## Changes

- Imported both as independent Java 21 projects, outside the existing Java 17 Maven reactor.
- Excluded macOS metadata, IDE state, Gradle caches and compiled files.
- Exam: reject blank/missing email, configure upstream URL and connection/read timeouts, return 502 on upstream failure, pin the Gradle distribution checksum, and replace the empty context test with behavioral tests.
- Store: moved the POM to the module root, added a reactor POM and Spring context startup test. Preserved unfinished business classes as a documented skeleton.

## Validation

- Exam: Gradle 8.14.3 `test bootJar` passed, 6 tests, zero failures/errors/skips.
- Store: Maven 3.9.9 `verify` passed, 1 context test, zero failures/errors/skips.
- Existing HomeWork reactor: all 18 modules built and all 77 tests passed.
- Launched both packaged applications using JDK 21.0.8. Exam HTTP checks passed for valid user (200), blank email (400), posts returned by a local upstream (200), disabled email endpoint (200), and unavailable upstream (502). The actual PostClient HTTP/JSON path was exercised against that local upstream.
- Store started with embedded H2; root returned expected 404 because no controller mappings exist. Processes started for validation were stopped.

## Limits

The live JSONPlaceholder service was not tested. Tests use a local HTTP stub or mocks. Email is only logged, not sent. User records are not persisted. Store product/order behavior is absent from the archive and remains unimplemented; a successful startup is not proof of a working store. No database credentials or real email addresses are required for these checks.
