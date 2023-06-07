FROM openjdk
EXPOSE 8787
RUN mkdir appspace
WORKDIR /appspace
VOLUME /appspace
COPY target/spring-with-redis-0.0.1-SNAPSHOT.jar /appspace/apprunner.jar
CMD ["java","-jar","/appspace/apprunner.jar"]
