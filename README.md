


docker network create sbnetwork

mvn clean install dockerfile:build

docker run -h admin-server --name admin-server -e SERVER_PORT=9090 -d -p 9090:9090 --network sbnetwork malloc/spring-boot-microservice-admin-server:0.0.1-SNAPSHOT

docker run -h eureka-server --name eureka-server -e SERVER_PORT=8761 -e ADMIN_SERVER=admin-server -e ADMIN_SERVER_PORT=9090 -e EUREKA_SERVER=eureka-server -d -p 8761:8761 --network sbnetwork malloc/spring-boot-microservice-eureka-server:0.0.1-SNAPSHOT
docker run -h eureka-client --name eureka-client -e SERVER_PORT=8080 -e ADMIN_SERVER=admin-server -e ADMIN_SERVER_PORT=9090 -e EUREKA_SERVER=eureka-server -e EUREKA_SERVER_PORT=8761 -d -p 8080:8080 --network sbnetwork malloc/spring-boot-microservice-eureka-client:0.0.1-SNAPSHOT


docker run -h forex-service --name forex-service -e SERVER_PORT=8000 -e ADMIN_SERVER=admin-server -e ADMIN_SERVER_PORT=9090 -e EUREKA_SERVER=eureka-server -e EUREKA_SERVER_PORT=8761 -d -p 8000:8000 --network sbnetwork malloc/spring-boot-microservice-forex-service:0.0.1-SNAPSHOT

docker run -h curreny-service --name curreny-service -e SERVER_PORT=8010 -e ADMIN_SERVER=admin-server -e ADMIN_SERVER_PORT=9090 -e EUREKA_SERVER=eureka-server -e EUREKA_SERVER_PORT=8761 -d -p 8010:8010 --network sbnetwork malloc/spring-boot-microservice-currency-conversion:0.0.1-SNAPSHOT