# Stage 1: Build
FROM maven:3.8.4-openjdk-17 AS build

WORKDIR /build

COPY pom.xml .
COPY src ./src

RUN mvn clean package

# Stage 2: Final
FROM openjdk:17-jdk-alpine

WORKDIR /app

COPY --from=build /build/target/*.jar /app/jobapp.jar

ENTRYPOINT exec java $JAVA_OPTS -jar jobapp.jar
