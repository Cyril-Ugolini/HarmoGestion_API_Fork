FROM openjdk:25
EXPOSE 8080
WORKDIR /app
COPY *.jar /app/harmogestion-api.jar
CMD ["java", "-jar", "harmogestion-api.jar"]