# syntax=docker/dockerfile:1
FROM openjdk:11
ADD target/openapi-spring-1.0.0.jar /home/openapi-spring-1.0.0.jar
CMD ["java","-jar","/home/openapi-spring-1.0.0.jar", "1", "2", "3", "4", "5", "6"]