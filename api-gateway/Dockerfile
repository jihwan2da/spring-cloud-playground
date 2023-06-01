FROM openjdk:17-jdk-slim

EXPOSE 8080

ARG PROJECT_DIRECTORY=/build

WORKDIR %PROJECT_DIRECTORY

ENTRYPOINT ["java","-jar","-Dspring.profiles.active=docker","/build/app.jar"]