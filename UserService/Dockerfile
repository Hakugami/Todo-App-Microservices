FROM maven:3.9-eclipse-temurin-21-alpine AS build

LABEL authors="islam ahmed,nada mahmoud ,nada emam, menna moataz"

WORKDIR /app

COPY pom.xml .

RUN mvn dependency:go-offline

COPY src src

RUN mvn package

FROM openjdk:21-jdk-slim

COPY --from=build /app/target/*.jar /app.jar

EXPOSE 4601

ENTRYPOINT ["java", "-jar", "/app.jar"]


