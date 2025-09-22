FROM eclipse-temurin:17-jdk-alpine

COPY build/libs/demo-0.0.1-SNAPSHOT.jar ejercicio-app.jar

ENTRYPOINT ["java","-jar","ejercicio-app.jar"]