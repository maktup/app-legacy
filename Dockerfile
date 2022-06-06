# DOCKERFILE para escenario de BUILD el proyecto con MAVEN.
FROM maven:3.5-jdk-8 as BUILD
 
COPY src /usr/src/app/src
COPY pom.xml /usr/src/app
RUN mvn -f /usr/src/app/pom.xml clean compile package

FROM icr.io/appcafe/open-liberty:kernel-slim-java8-openj9-ubi

COPY /src/main/liberty/config/server.xml /config/
RUN features.sh
COPY --from=BUILD /usr/src/app/target/*.war /config/apps/
EXPOSE 9080
EXPOSE 9443
RUN configure.sh
