# Use the official Tomcat image as the base image
FROM tomcat:10.1.7-jdk17

# Set the environment variable to avoid error messages
ENV JAVA_OPTS="-Djava.security.egd=file:/dev/./urandom"

# Remove the default webapps to keep the image clean
RUN rm -rf /usr/local/tomcat/webapps/*

# Copy the WAR file to the webapps directory
COPY target/Project-0.0.1-SNAPSHOT.war /usr/local/tomcat/webapps/ROOT.war

# Expose the default Tomcat port
EXPOSE 8080

# Start Tomcat
CMD ["catalina.sh", "run"]
