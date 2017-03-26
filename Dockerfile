FROM gradle:jdk8

WORKDIR /usr/src/app

COPY . /usr/src/app/
RUN ./gradlew build

EXPOSE 3000

CMD ["./gradlew", "run"]
