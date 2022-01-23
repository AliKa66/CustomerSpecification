## Build & Run Spring Boot
### Builds the application
```
./mvnw clean package spring-boot:repackage
```
Check Java version in Maven if an error occurs. It should be Java version 17.
```
./mvnv -version
```
### Runs the application
```
java -jar target/CustomerSpecification-0.0.1-SNAPSHOT.jar
```

### Quick compile and run
```
./mvnw spring-boot:run
```

## Run Angular
### Go to folder UI
### Install Node packages
```
npm install
```

### Start Angular UI and open it on the browser
```
ng serve --open
```
