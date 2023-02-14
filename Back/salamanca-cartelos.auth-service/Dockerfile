FROM maven:latest

WORKDIR /auth-service
COPY . .
RUN mvn clean install

CMD [ "mvn", "spring-boot:run" ]