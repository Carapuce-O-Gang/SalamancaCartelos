FROM maven:latest

WORKDIR /proposals-service
COPY . .
RUN mvn clean install

CMD [ "mvn", "spring-boot:run" ]