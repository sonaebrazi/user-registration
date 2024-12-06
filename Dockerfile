# Use the official Java image
FROM openjdk:22-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file into the container
COPY target/registration-service-0.0.1-SNAPSHOT.jar app.jar

# Expose port 8080, since your application runs on that port
EXPOSE 8080

# Run the application when the container starts
ENTRYPOINT ["java", "-jar", "app.jar"]