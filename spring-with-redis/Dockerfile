FROM openjdk
EXPOSE 8787
VOLUME /tmp
ARG JAR_FILE=target/spring-with-redis-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
