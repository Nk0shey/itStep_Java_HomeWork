# Spring Boot exam

Java 21, Spring Boot 3.5.3, Gradle 8.14.3.

```sh
./gradlew test bootJar
./gradlew bootRun
```

The application listens on port 8080 by default (`--server.port=8081` overrides it).

- `POST /users` with JSON `{"name":"Ivan","email":"ivan@example.org"}` validates input and returns a confirmation; users are not persisted. Blank names/emails and malformed email addresses return 400.
- `GET /posts` retrieves JSONPlaceholder posts. Override `posts.url` to use a different upstream. Connection/read timeouts are 5/10 seconds; upstream failures return 502. Internet access is required for the default upstream.
- `POST /email?to=test@example.org` demonstrates a feature flag. It logs a message only: no actual email is sent. `feature.email.enabled=false` by default.

Tests cover request validation, post responses and upstream errors, post deserialization, and the disabled email path. External APIs are mocked in tests; no real email or remote write is performed.

Imported from exam.zip without IDE files, build outputs, or Gradle caches. The original archive remains outside the repository.
