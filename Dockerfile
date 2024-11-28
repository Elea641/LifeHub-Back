FROM openjdk:17-jdk-slim

# Installer les dépendances nécessaires (comme curl, tar)
RUN apt-get update && apt-get install -y \
    curl \
    tar \
    && rm -rf /var/lib/apt/lists/*  # Nettoie les fichiers temporaires pour alléger l'image

# Configuration de l'environnement de travail
WORKDIR /app

# Copier le code de l'application
COPY . .

# Exécuter le script de démarrage
CMD ["./mvnw", "spring-boot:run"]
