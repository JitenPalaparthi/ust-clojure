FROM clojure:openjdk-17-lein-bullseye AS builder

WORKDIR /usr/src/app

COPY project.clj ./

COPY src ./src

RUN lein deps

RUN lein uberjar

FROM eclipse-temurin:17-jre-focal
WORKDIR /usr/app

COPY --from=builder  /usr/src/app/target/uberjar/demo41-*-standalone.jar ./app.jar

EXPOSE 8081

ENTRYPOINT [ "java" ,"-jar","./app.jar" ]























