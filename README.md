# spring-cloud-playground. 
  
spring-cloud-playground is develop playground for learning msa with spring cloud. 

  
it contains **Centralized Configuration Management**, **Service Discovery**, **Load Distribution(Load Balancing)**, **Routing**, **Docker Container** and will contain **Easier Rest Client(FeignClient)**, **Circuit Breakers**, **Distributed Tracing**, **Queueing Service**

## Getting Start
```shell
./gradlew clean build -x test

docker-compose up -d
```
if you want to start domain micro service more serve, use docker-compose --scale option
```shell
docker-compose up -d --scale user=2 --scale order=3 --scale product=2
```

## Technology List
- Spring Cloud Gateway
- Spring Netflix Eureka Server
- Spring Netflix Eureka Client
- Spring Cloud Config
- Spring Boot 3.0.x
- Docker
