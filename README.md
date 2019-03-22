#Spring Boot project for learning

Download source, open terminal and type "./gradlew bootJar".
After task finished go to the libs directory and type in terminal "java -jar spring-0.1-SNAPSHOT.jar".  
At the endpoint "person" (http://localhost:8080/person) you could see added records. 
In resources/application.properties you could change h2 database location and other settings such as 
login or password (It's for education purpose so forgive any insecure features).  
Records could be added,
modified or deleted via HTTP methods (GET, POST, PUT, DELETE) using e.g. curl or postman.