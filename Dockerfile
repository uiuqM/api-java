FROM openjdk:17
ADD target/api-javaRestful.jar api-java-rest.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "api-java-rest.jar"]