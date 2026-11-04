# Microservices store — unfinished exercise

This archive contains a Spring Boot product-service skeleton, **not a working store**. Product, ProductController, ProductRepository and ProductSpecification are empty classes. No product or order HTTP API, order implementation, or service-to-service communication exists in the supplied archive. The empty order-service directory is not a runnable module.

The misplaced product POM has been moved from `product-service/src/pom.xml` to `product-service/pom.xml`; a root Maven reactor now builds the module using the standard source layout. Java 21 and Maven 3.9+ are required.

```sh
mvn verify
java -jar product-service/target/product-service-0.0.1-SNAPSHOT.jar --server.port=8081
```

The Spring application uses the embedded H2 database by default and starts an HTTP server; requests without a defined controller return 404. A context startup test checks the skeleton. PostgreSQL configuration and store business functionality are not supplied.

Imported from microservices-store.zip without IDE/macOS metadata. Publishing this skeleton does not establish that a store works.
