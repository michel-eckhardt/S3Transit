FROM openjdk:17-jdk-slim

RUN apt-get update && \
    apt-get install -y maven && \
    rm -rf /var/lib/apt/lists/*

# Diretório de trabalho dentro do contêiner
WORKDIR /app

# Copie os arquivos de código-fonte para o contêiner
COPY . /app

# Execute o comando Maven para construir o aplicativo
RUN mvn clean install

# Comando para iniciar o aplicativo Spring Boot
CMD ["java", "-jar", "target/s3transit-0.0.1-SNAPSHOT.jar"]