FROM openjdk:17
COPY ./target/*.jar /usr/src/app/
WORKDIR /usr/src/app
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "assurance-0.0.1-SNAPSHOT.jar"]