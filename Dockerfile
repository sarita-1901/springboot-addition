FROM openjdk:17-jdk-alpine
ADD target/addition-rest-api.jar addition-rest-api.jar
ENTRYPOINT ["sh","-c", "java -jar /addition-rest-api.jar"]
