#Start with a base image containing Java runtime
FROM bellsoft/liberica-openjre-debian:21-cds

# Add Maintainer Info
MAINTAINER BK

# Add the application's jar to the container
COPY target/Accounts-0.0.1-SNAPSHOT.jar Accounts-0.0.1-SNAPSHOT.jar

# execute the application
ENTRYPOINT ["java","-jar","Accounts-0.0.1-SNAPSHOT.jar"]
