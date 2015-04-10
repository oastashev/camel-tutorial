#Build WAR

`mvn clean package -U`

#Run under Tomcat 7

`mvn clean tomcat7:run -U`

##Incoming data
- Files folder - `target/!incoming` 
- HTTP API - `http://localhost:8080/camel-tutorial/gateway/resolve/?ip=8.8.8.8` 
