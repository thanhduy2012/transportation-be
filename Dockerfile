FROM maven:3.6.3-jdk-8

WORKDIR /opt/app

COPY . .

RUN mvn clean package -P prod

CMD ["java", "-jar", "target/*.jar"]

