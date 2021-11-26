FROM adoptopenjdk/openjdk11:latest
VOLUME /tmp
VOLUME /data/resoluciones
COPY "./build/libs/sds-resolutions-1.0.jar" "app.jar"
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
ENV SPRING_PROFILES_ACTIVE docker
ENV RESOLUTION_FILE /data/resoluciones/Resolucion_{id}.pdf