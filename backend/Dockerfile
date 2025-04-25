# -------- Build Stage --------
FROM gradle:8.4-jdk21 AS builder

WORKDIR /app

COPY build.gradle /app/
RUN gradle build --no-daemon || true

COPY src /app/src
RUN gradle clean build -x test --no-daemon


# -------- Runtime Stage --------
FROM amazoncorretto:21-alpine-jdk

WORKDIR /app

COPY --from=builder /app/build/libs/*.jar /app/

RUN ls -al /app/

EXPOSE 8080
CMD ["sh", "-c", "java -jar /app/app-1.0.0.jar --server.port=$PORT"]
