FROM amazoncorretto:17-alpine-jdk
ADD target/survey-api.jar survey-api.jar
ENTRYPOINT ["java", "-jar", "survey-api.jar"]