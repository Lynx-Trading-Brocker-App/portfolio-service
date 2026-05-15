# Stage 1: Build with Gradle
FROM gradle:8.10.2-jdk21 AS build
WORKDIR /app
COPY . .
RUN gradle clean bootJar --no-daemon

# Stage 2: Run with JRE
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app
# Adjust the jar name if your project name is different
COPY --from=build /app/build/libs/*.jar app.jar
EXPOSE 9004
ENTRYPOINT ["java", "-jar", "app.jar"]