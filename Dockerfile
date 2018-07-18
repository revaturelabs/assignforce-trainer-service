FROM java:8
ADD target/trainer-service.jar .
EXPOSE 8674
CMD java -jar -Xmx512M trainer-service.jar