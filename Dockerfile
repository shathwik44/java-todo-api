# Use a Java runtime base image
FROM eclipse-temurin:17-jdk

# Set working directory
WORKDIR /app

# Copy the built jar (update the name to match your artifact)
COPY target/java-todo-api-0.0.1-SNAPSHOT.jar app.jar

# Run the app
CMD ["java", "-jar", "app.jar"]