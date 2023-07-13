FROM openjdk:11
EXPOSE 8082
RUN mkdir -p /app/
ADD build/libs/service-plazoleta-0.0.1-SNAPSHOT.jar /app/service-plazoleta-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "/app/service-plazoleta-0.0.1-SNAPSHOT.jar"]