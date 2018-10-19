# Start with a base image containing Java runtime
FROM openjdk:8-jdk-alpine

# Fix DNS resolution issues when nss is not installed
RUN echo 'hosts: files mdns4_minimal [NOTFOUND=return] dns mdns4' >> /etc/nsswitch.conf

# Set DNS cache to 10 seconds (Cache is permanent by default). Network hosts are volatile in Docker clusters.
RUN grep '^networkaddress.cache.ttl=' /${JAVA_HOME}/jre/lib/security/java.security || echo 'networkaddress.cache.ttl=10' >> /${JAVA_HOME}/jre/lib/security/java.security

ENV SERVER_PORT=8000

# The application's jar file
ARG JAR_FILE=target/spring-boot-microservice-user-service-0.0.1-SNAPSHOT.jar

# Add the application's jar to the container
ADD ${JAR_FILE} app.jar

#RUN bash -c 'touch /app.jar'

# Run the jar file 
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-Dspring.profiles.active=container","-jar","/app.jar"]

EXPOSE ${SERVER_PORT}
