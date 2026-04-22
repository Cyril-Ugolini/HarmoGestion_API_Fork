FROM openjdk:21
EXPOSE 8080
WORKDIR /app
COPY *.jar /app/harmogestion-api.jar
CMD ["java", "-jar", "harmogestion-api.jar"]