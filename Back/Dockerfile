FROM mysql:latest

MAINTAINER carapuce-o-gang

ENV MYSQL_ROOT_PASSWORD=toor

ADD schema.sql /docker-entrypoint-initdb.d

EXPOSE 3306