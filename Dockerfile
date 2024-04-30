FROM openjdk:18-jdk-alpine

COPY ./target/testingsp-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar" , "/app.jar"]