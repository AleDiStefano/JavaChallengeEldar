FROM openjdk:21-jdk-slim
ARG JAR_FILE=target/EldarEj2-0.1.jar
COPY ${JAR_FILE} JavaChallenge_Ej2.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar","JavaChallenge_Ej2.jar"]