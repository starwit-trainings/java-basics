# A larger example
This section will run an app, that has a network interface and offers some functions. It is based on Spring Boot and will use REST services to expose data and functions.

```bash
    cd restexample
    mvn clean package
    java -jar target/restexample.jar
```

## Tasks
* run app
* open in your browser: http://localhost:8080/swagger-ui/index.html & try all methods
* Application already loads club data from CSV file - implement service and controller functions for all CSV files
* Imagine you want to find players playing for a club - can we write a function, that collects necessary data?