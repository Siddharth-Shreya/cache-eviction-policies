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

FROM openjdk:17-jdk-slim

EXPOSE 8080

COPY --from=build /backend/build/libs/cachesimulator-0.0.1-SNAPSHOT.jar /app/cachesimulator.jar

ENTRYPOINT ["java", "-jar", "/app/cachesimulator.jar"]
