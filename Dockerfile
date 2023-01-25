FROM openjdk:17-jdk-slim

WORKDIR /app

COPY /build/libs/metrics-demo*.jar /app/metrics-demo.jar

EXPOSE 9991

ENTRYPOINT ["java", "-jar", "metrics-demo.jar"]