# Use a Java runtime base image
FROM eclipse-temurin:17-jdk

# Set working directory
WORKDIR /app

# Copy the jar (make sure it exists after build)
COPY target/*.jar app.jar

# Run the app
CMD ["java", "-jar", "app.jar"]