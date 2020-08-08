FROM maven:3.5-jdk-8-alpine as build
WORKDIR /app
COPY . /app
RUN mvn package

FROM openjdk:8-jre-alpine
COPY --from=build /app/target/patient-0.0.1-SNAPSHOT.jar ./server.jar
EXPOSE 8084
ENTRYPOINT ["java", "-jar", "./server.jar"]
