# syntax=docker/dockerfile:1

FROM eclipse-temurin:17-jdk-jammy as base
WORKDIR /app
COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN ./mvnw dependency:resolve
COPY src ./src

# Use in-memory db for testing
ENV DB_URL=jdbc:h2:mem:testdb

FROM base as test
CMD ["./mvnw", "test"]

FROM base as development
CMD ["./mvnw", "spring-boot:run", "-Dspring-boot.run.jvmArguments='-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:8000'"]

FROM base as build
RUN ./mvnw package

FROM eclipse-temurin:17-jdk-jammy as production
EXPOSE 8080
COPY --from=build /app/target/ecommerce_app-*.jar /ecommerce_app.jar
CMD ["java", "-jar", "/ecommerce_app.jar"]