# A larger example
This section introduces a number of larger apps, that shall demonstrate realistic Java applications.


## Example List

### Football manager - naive approach
This example shall combine parsed in data from last chapters with a network interface. It is based on Spring Boot and will use REST services to expose data and functions.

How to run example:
```bash
    cd restexample
    mvn clean package
    java -jar target/restexample.jar
```

#### Tasks
* run app
* open in your browser: http://localhost:8080/swagger-ui/index.html & try all methods
* Application already loads club data from CSV file - implement service and controller functions for all CSV files
* Imagine you want to find players playing for a club - can we write a function, that collects necessary data?

### Football manager - introducing data bases
CSV files are obviously a storage concept, that is very limited. A much better approach are relational databases. Here is an example, that does the same thing as the last one, but is using [PostgreSQL](https://www.postgresql.org/) as database. 

How to run example:
```bash
    # Start database
    cd database
    cd deployment
    docker compose up
```

```bash
    # Build & run app
    cd database
    mvn clean package
    java -jar target/database.jar
```

#### Tasks
* run app
* open in your browser: http://localhost:8080/swagger-ui/index.html & add data
* Look at Docker compose script - 