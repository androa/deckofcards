FROM gradle:jdk8

WORKDIR /usr/src/app

COPY . /usr/src/app/

EXPOSE 3000

CMD ["java", "Main"]
