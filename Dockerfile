FROM ubuntu:latest
FROM openjdk:21-jdk

LABEL authors="mtolstov"

WORKDIR /app

COPY /target/tic-tac-toe-1.0-SNAPSHOT.jar /app/tic-tac-toe.jar


CMD ["java", "-jar", "tic-tac-toe.jar"]