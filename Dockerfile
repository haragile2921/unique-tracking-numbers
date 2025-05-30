FROM eclipse-temurin:17-jdk-alpine AS build
WORKDIR /app
 
COPY .mvn .mvn
COPY mvnw pom.xml ./
RUN ./mvnw dependency:go-offline
 
COPY src ./src
RUN ./mvnw clean clean verify
 
FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
 
COPY --from=build /app/target/unique-tracking-numbers.jar app.jar
 
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]