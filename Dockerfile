FROM openjdk:18-jdk
COPY basket-api-0.0.1-SNAPSHOT.jar /demo.jar
CMD ["java", "-jar", "/demo.jar"]