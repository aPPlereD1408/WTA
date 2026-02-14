# Build Stage (bleibt gleich)
FROM maven:3.9-eclipse-temurin-17 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Run Stage (HIER DIE ÄNDERUNG)
# Alt: FROM eclipse-temurin:17-jre-alpine
# Neu (Nimm die Standard JRE, die läuft garantiert auf Mac & Windows):
FROM eclipse-temurin:17-jre
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
