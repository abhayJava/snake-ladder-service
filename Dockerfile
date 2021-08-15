FROM maven:3.5-jdk-8
RUN mkdir /app
WORKDIR /app
RUN mkdir /src
COPY src/ /app/src/
COPY pom.xml /app/
WORKDIR /app

ENTRYPOINT ["mvn","clean","spring-boot:run"]