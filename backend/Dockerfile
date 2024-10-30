FROM ubuntu:latest AS build
RUN apt-get update && \
    apt-get install -y openjdk-17-jdk && \
    apt-get install -y curl unzip

WORKDIR /backend

COPY gradlew ./
COPY gradle gradle
COPY build.gradle settings.gradle ./
RUN chmod +x gradlew

RUN ./gradlew dependencies --no-daemon

COPY src src
RUN ./gradlew bootJar --no-daemon

FROM openjdk:17-jdk-slim
WORKDIR /app
EXPOSE 8080

COPY --from=build /backend/build/libs/cachesimulator-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]
