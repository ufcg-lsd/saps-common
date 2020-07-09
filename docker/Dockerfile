FROM maven:3.6.3-jdk-8 AS builder

WORKDIR /app

COPY pom.xml .
COPY src  ./src
RUN mvn -e -B clean install

FROM alpine

WORKDIR /app

COPY --from=builder /app/target/saps-common-0.0.1-SNAPSHOT.jar saps-common-0.0.1-SNAPSHOT.jar
