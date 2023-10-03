FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
VOLUME api
COPY target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app/app.jar"]