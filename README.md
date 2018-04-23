# customer-services1
Spring boot RESTful service which utilizes hibernate, JPA, H2 database, swagger-ui and Angular5.

The data is persisted with H2 database via JPA and Hibernate. 

### Instructions for starting oritmalki/customer-services:secondcommit from docker image:

Link to Docker image: https://hub.docker.com/r/oritmalki/customer-services/

#### Running the image:

1. Start docker.
2. Run image from repository using command: ```$ docker run -p 80:8082 oritmalki/customer-services:secondcommit```
3. Go to URL http://localhost:8082/swagger-ui.html#/ or {docker ip address}/swagger-ui.html#/
4. If you are using virtual box or toolbox, use docker’s default IP address as host (for example 192.168.99.100). You can see the default IP at docker’s startup, or use command: ```$docker-machine default ip.```

#### Navigation links:
API Documentation: http://localhost:8082/swagger-ui.html or http://192.168.99.100/swagger-ui.html for docker toolbox users (get the exact host ip address as described in step 4).
H2 database persistance: http://localhost:8082/console

#### Note1: 
The application is configured to run on host server port 8082. Docker's container default port is 80 (embedded tomcat default).

#### Note2: 
The docker image does not include the client-side app.

##### If you wish to run it with the client you may clone this repository and run it on your machine:
1. go to project folder: ```$cd <project path>``` (this <> is a place holder)
2. start spring boot service: ```$ ./mvnw spring-boot:run```
3. go to client folder in project: ```$cd <project path>/client```
4. run the client server: ```$ ng serve``` (make sure you got node.js installed first)
5. open your browser at http://localhost:4200

