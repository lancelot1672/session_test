FROM openjdk:11-jdk
ARG JAR_FILE=build/libs/*.jar

EXPOSE 9000

COPY ${JAR_FILE} app.jar

ENTRYPOINT ["java","-jar","-Dspring.profiles.active=dev","/app.jar"]