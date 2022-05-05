# syntax=docker/dockerfile:1
FROM anapsix/alpine-java
ADD target/openapi-spring-1.0.0.jar /home/openapi-spring-1.0.0.jar
CMD ["java","-jar 1 2 3 4 5 6","/home/openapi-spring-1.0.0.jar"]