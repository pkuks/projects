FROM openjdk:8-jre-alpine
COPY ./target/friendsbook-0.0.1-SNAPSHOT.jar /usr/src/friendsbook/
RUN chmod -R 777 /usr/src/friendsbook/friendsbook-0.0.1-SNAPSHOT.jar
ENTRYPOINT exec java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /usr/src/friendsbook/friendsbook-0.0.1-SNAPSHOT.jar
WORKDIR /usr/src/friendsbook
CMD ["java", "-jar", "friendsbook-0.0.1-SNAPSHOT.jar"]