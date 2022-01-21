### Builds the application
```
./mvnw clean package spring-boot:repackage
```
### Runs the application
```
java -jar target/CustomerSpecification-0.0.1-SNAPSHOT.jar
```

### Quick compile and run
```
./mvnw spring-boot:run
```

### Example API
- GET /questions?amount=5   
    Returns a list of questions with a size of 5.
- POST /checkanswer         
    Checks if the answer is correct. Returns true or false.

