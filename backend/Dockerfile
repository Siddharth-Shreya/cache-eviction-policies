FROM ubuntu:latest AS build
RUN apt-get update
RUN apt-get install openjdk-17-jdk -y
WORKDIR /backend

COPY . .
RUN ./gradlew bootJar --no-daemon

FROM openjdk:17-jdk-slim
EXPOSE 8080

ENTRYPOINT ["java", "-jar", "build/libs/cachesimulator-0.0.1-SNAPSHOT.jar"]