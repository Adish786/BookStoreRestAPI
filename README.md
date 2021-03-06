# BookStoreRestAPI

# Sample REST CRUD API with Spring Boot, Mysql, JPA and Hibernate 

## Steps to Setup

**2. Create Mysql database**
```bash
create database user_database
```

**3. Change mysql username and password as per your installation**

+ open `src/main/resources/application.properties`

+ change `spring.datasource.username` and `spring.datasource.password` as per your mysql installation

**4. Build and run the app using maven**

```bash
mvn package
java -jar target/spring-boot-rest-api-tutorial-0.0.1-SNAPSHOT.jar

```

Alternatively, you can run the app without packaging it using -

```bash
mvn spring-boot:run
```

The app will start running at <http://localhost:9191>.

## Explore Rest APIs

The app defines following CRUD APIs.

    GET localhost:9191/books/
    
    POST localhost:9191/books/id
    
    GET localhost:9191/books/id
    
    PUT localhost:9191/books/id
    
    DELETE localhost:9191/books/id

