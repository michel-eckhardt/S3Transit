FROM openjdk:17-jdk-slim

RUN apt-get update && \
    apt-get install -y maven && \
    rm -rf /var/lib/apt/lists/*

WORKDIR /app
COPY . /app

RUN mvn clean install

CMD ["java", "-jar", "target/s3transit-0.0.1-SNAPSHOT.jar"]