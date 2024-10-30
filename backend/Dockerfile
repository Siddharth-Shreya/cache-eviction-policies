FROM openjdk:17-jdk-slim AS build

WORKDIR /backend

COPY gradlew .
COPY gradle gradle
COPY build.gradle .
COPY settings.gradle .

RUN chmod +x gradlew

COPY src src

RUN ./gradlew clean

RUN ./gradlew bootJar --no-daemon --stacktrace --info
