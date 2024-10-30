FROM openjdk:17-jdk-slim

WORKDIR /backend

COPY . .

RUN ./gradlew build

CMD ["java", "-jar", "build/libs/cachesimulator-0.0.1-SNAPSHOT.jar"]