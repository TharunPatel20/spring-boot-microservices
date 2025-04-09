# Create docker image of this spring boot project

# Base image for this spring boot project
FROM eclipse-temurin:21-jre

# Setup the workdir
WORKDIR /app

# Copy the .jar files from the target folder into app.jar file
COPY target/*.jar app.jar

# Expose the service port
EXPOSE 8092

# Command to execute the service application
ENTRYPOINT ["java", "-jar", "app.jar"]