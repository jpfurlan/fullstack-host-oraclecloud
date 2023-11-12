# Use a base image for Java (escolha a versão que você precisa)
FROM openjdk:17-oracle

# Copie o arquivo jar compilado para a imagem
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar

# Exponha a porta que o Spring Boot usa
EXPOSE 8080

# Execute o jar
ENTRYPOINT ["java","-jar","/app.jar"]
