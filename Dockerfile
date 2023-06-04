FROM openjdk:8-jre

WORKDIR app

COPY target/*.jar app.jar

CMD ["java", "-jar", "app.jar"]