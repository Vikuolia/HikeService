FROM openjdk:11-jre
WORKDIR D: /3 курс/ТРСПО/lab3/hike/out/artifacts/hike_jar
EXPOSE 8088
ENTRYPOINT ["java","-jar","/app.jar"]