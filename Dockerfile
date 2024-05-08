FROM openjdk:17-jdk-alpine


WORKDIR /app


COPY target/*.jar /app/jobapp.jar


ENTRYPOINT exec java $JAVA_OPTS -jar jobapp.jar
