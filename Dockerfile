
# Build the image with:
#
# docker build -f Dockerfile -t app .
#
# Run the docker image:
#
# docker run -p 8080:8080 -t app


FROM gradle:jdk-alpine AS build
COPY --chown=gradle:gradle . /Users/ideltuva/workspace/loans/
WORKDIR /Users/ideltuva/workspace/loans/
RUN gradle build --no-daemon

FROM openjdk:8-jre-slim
RUN mkdir /app
WORKDIR /app --rm=false
COPY build/libs/loans-0.0.1.jar /app/loans.jar
CMD ["java","-jar","/app/loans.jar"]
