# Utiliser une image de base Java
FROM openjdk:18-jdk-alpine

# Copier le fichier JAR de l'application dans l'image
COPY ./target/testingsp-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar" , "/app.jar"]