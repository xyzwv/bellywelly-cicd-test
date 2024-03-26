FROM openjdk:17-alpine
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","-Duser.timezone=Asia/Seoul","/app.jar}"]

FROM nginx:latest
COPY ./config/nginx/default.conf /etc/nginx/conf.d/default.conf
