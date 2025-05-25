# Stage 1: Build the app
FROM eclipse-temurin:17-jdk-alpine AS build
WORKDIR /app
 
# Copy Maven wrapper and POM
COPY .mvn .mvn
COPY mvnw pom.xml ./
RUN ./mvnw dependency:go-offline
 
# Copy source and build
COPY src ./src
RUN ./mvnw clean package -DskipTests
 
# Stage 2: Run the app
FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
 
# Copy the built JAR from build stage
COPY --from=build /app/target/unique-tracking-numbers.jar app.jar
 
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]