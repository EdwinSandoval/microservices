#FROM openjdk:11
#VOLUME /tmp
#ENV
#EXPOSE
#RUN
#ADD
#ENTRYPOINT

# Usa la imagen base de Java 11
#FROM openjdk:11
#
## Establece el directorio de trabajo dentro del contenedor
#WORKDIR /app
#
## Copia el archivo build.gradle y el directorio src a la imagen
#COPY build.gradle .
#COPY src ./src
#
## Ejecuta la construcción del proyecto con Gradle
#RUN ./gradlew build
#
## Expone el puerto en el que se ejecutará la aplicación
#EXPOSE 8080
#
## Comando para ejecutar la aplicación
#CMD ["java", "-jar", "build/libs/usuario-service-0.0.1-SNAPSHOT.jar"]
#-----------------------------------------------------------------------------------
#-----------------------------------------------------------------------------------

FROM openjdk:11
EXPOSE 8081
RUN mkdir -p /app/
ADD build/libs/usuario-service-0.0.1-SNAPSHOT.jar /app/usuario-service-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "/app/usuario-service-0.0.1-SNAPSHOT.jar"]