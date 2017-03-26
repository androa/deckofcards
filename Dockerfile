FROM gradle:jdk8

WORKDIR /home/gradle/

COPY . /home/gradle/
RUN ./gradlew build

CMD ["./gradlew", "run"]
