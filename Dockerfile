FROM gradle:6.0.1-jdk8 AS build
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle build -x test --no-daemon

FROM openjdk:8-jdk-alpine
RUN apk add --no-cache bash
MAINTAINER dramaticparsley@gmail.com
COPY --from=build /home/gradle/src/build/libs/*.jar /app/Application.jar
ENTRYPOINT ["java","-jar","/app/Application.jar", "bootRun"]