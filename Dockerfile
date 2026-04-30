# Dockerfile de l'application HarmoGestion_API.
# Définit l'image Java utilisée, le port exposé, le répertoire de travail,
# la copie du JAR généré et la commande de lancement de l'application.
#
# @author UGOLINI Cyril
# @version 0.0.1
# @since 22/04/2026

# Utilise Java 25 (Temurin) comme image de base
FROM eclipse-temurin:25

# Expose le port 8080 utilisé par Spring Boot
EXPOSE 8080

# Définit le répertoire de travail dans le conteneur
WORKDIR /app

# Copie le JAR généré par Maven dans le conteneur
COPY *.jar /app/harmogestion-api.jar

# Commande exécutée au démarrage du conteneur
CMD ["java", "-jar", "harmogestion-api.jar"]