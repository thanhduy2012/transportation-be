FROM maven:3.6.3-jdk-8 as buildJar

WORKDIR /opt/app

COPY . .

RUN mvn clean package -P prod




FROM openjdk:8

WORKDIR /opt/be

COPY --from=buildJar /opt/app .

RUN ls

CMD ["java", "-jar", "target/*.jar"]

