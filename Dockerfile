FROM openjdk:17-jdk-slim

WORKDIR /app

COPY /build/libs/metrics-demo-0.0.1-SNAPSHOT.jar /app/metrics-demo.jar

EXPOSE 9991

ENTRYPOINT ["java", "-jar", "metrics-demo.jar"]