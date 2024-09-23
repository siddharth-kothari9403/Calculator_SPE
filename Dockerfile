FROM openjdk:17

COPY ./target/Calculator_SPE-1.0-SNAPSHOT.jar ./

WORKDIR ./

CMD ["java", "-jar","Calculator_SPE-1.0-SNAPSHOT.jar"]