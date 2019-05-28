FROM openjdk:8-jdk-alpine
ENV APP_FILE springbootkbe-0.1.0-SNAPSHOT.jar
ENV APP_HOME /usr/app
EXPOSE 8000
COPY build/libs/*.jar $APP_HOME/
WORKDIR $APP_HOME
ENTRYPOINT ["sh", "-c"]
CMD ["exec java -jar $APP_FILE"]