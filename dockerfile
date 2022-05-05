# syntax=docker/dockerfile:1
FROM anapsix/alpine-java
ADD target/my-app-*.jar /home/myjar.jar
CMD ["java","-jar 1 2 3 4 5 6","/home/myjar.jar"]