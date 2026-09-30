FROM maven:3.9.9-eclipse-temurin-17 AS build
WORKDIR /workspace/app
COPY app/pom.xml ./pom.xml
RUN mvn -B -q dependency:go-offline
COPY app/src ./src
RUN mvn -B -DskipTests package

FROM tomcat:10.1-jdk17-temurin
LABEL org.opencontainers.image.title="Automated Alumni Mentorship Platform"
LABEL org.opencontainers.image.description="Course MVP deployment image"
RUN rm -rf /usr/local/tomcat/webapps/*
COPY --from=build /workspace/app/target/alumni-mentorship.war /usr/local/tomcat/webapps/alumni-mentorship.war
EXPOSE 8080
HEALTHCHECK --interval=30s --timeout=5s --start-period=45s --retries=3 CMD wget -qO- http://localhost:8080/alumni-mentorship/api/health || exit 1
