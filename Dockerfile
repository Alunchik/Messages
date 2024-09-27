FROM maven:3.8.3-openjdk-17 AS build
COPY virtualization/src /home/app/src
COPY virtualization/pom.xml /home/app
WORKDIR /home/app
VOLUME /app/data
RUN mvn clean install -DskipTests=true

FROM eclipse-temurin:17.0.7_7-jre-jammy
LABEL author='Alekperova Alla IKBO-01-21'
ONBUILD CMD [ "echo", "Сборка и запуск произведены. Автор: Алекперова Алла Рауфовна" ]
ENV DBNAME=virtualization
ENV DBUSER=postgres
ENV DBPASS=admin
USER root
RUN ["wget", "-O", "/usr/local/lib/logo.png", "https://www.mirea.ru/upload/medialibrary/80f/MIREA_Gerb_Colour.png"]
COPY --from=build /home/app/target/virtualization-0.0.1-SNAPSHOT.jar /usr/local/lib/app.jar
EXPOSE 8083
ENTRYPOINT ["java", "-jar", "/usr/local/lib/app.jar"]
