FROM openjdk:17-alpine as jre-build
WORKDIR /wrk
COPY create-jre.sh .
RUN ./create-jre.sh

FROM maven:3.8.5-openjdk-17 as app-build
WORKDIR /usr/src/app/
COPY . /usr/src/app/
RUN mvn clean install -DskipTests

FROM alpine:3.14.6
WORKDIR /app
ENV DBSERVICE=""
COPY --from=jre-build /wrk /jre
COPY --from=app-build  /usr/src/app/ /app
EXPOSE 8080
ENTRYPOINT /jre/jre/bin/java -jar /app/target/demo-0.0.1-SNAPSHOT.jar --spring.datasource.url=jdbc:mysql://$DBSERVICE/demo-db
