# Use Maven with JDK 17 to build the app
FROM maven:3.9.6-eclipse-temurin-17 AS build

WORKDIR /app

# Copy source code and build
COPY . .
RUN ./mvnw clean package -DskipTests

# Runtime image
FROM eclipse-temurin:17-jdk

WORKDIR /app

# Copy the jar from the build stage
COPY --from=build /app/target/*.jar app.jar

CMD ["java", "-jar", "app.jar"]
