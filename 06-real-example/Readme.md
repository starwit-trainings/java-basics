# A larger example
This section introduces a number of larger apps, that shall demonstrate realistic Java applications. Here you will need all many aspects of Java, so it is recommended, that you finish earlier chapters.

## Spring Boot Framework
All examples in this section using the [Spring Boot](https://spring.io/projects/spring-boot) framework. This is a vast collection of libraries, that helps you writing applications. From batch processing to RESTful web services everything can be done with Spring Boot. 

The framework also emphasizes the creation of a single executable file. This is practical as it packages your entire application into something, that can be executed with a single command. A single executable is also very handy, as today almost all software is delivered with Docker containers.

## Example List

### Football manager - naive approach
This example shall combine parsed in data from last chapters with a network interface. It is based on Spring Boot and will use REST services to expose data and functions.

How to run example:
```bash
    cd restexample
    mvn clean package
    java -jar target/restexample.jar
```

#### Concepts covered
* [HTTP protocol](https://en.wikipedia.org/wiki/HTTP)
* [RESTful services](https://en.wikipedia.org/wiki/REST)
* [HTTP context path](https://www.baeldung.com/spring-context-vs-servlet-path)

#### Tasks
* run app
* open in your browser: http://localhost:8080/swagger-ui/index.html & try all methods
* Application already loads club data from CSV file - implement service and controller functions for all CSV files
* Imagine you want to find players playing for a club - can we write a function, that collects necessary data?
* How would we save new data?
* Can you think of disadvanteges of this architecture?

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

#### Concepts covered
* [JPA](https://en.wikipedia.org/wiki/Jakarta_Persistence)
* [Dependency Injection](https://en.wikipedia.org/wiki/Jakarta_Persistence)
* [Docker compose](https://docs.docker.com/compose/intro/compose-application-model/)
* [CRUD](https://en.wikipedia.org/wiki/Create,_read,_update_and_delete)

#### Tasks
* run app, if you can't use Docker, start a PostgreSQL on your computer
* open in your browser: http://localhost:8080/swagger-ui/index.html & add data
* See football example in [chapter 04](../04-ood/Readme.md) - implement all other entities.
* Implement CRUD operations for all entities
* Consider a league report, that contains infos for all clubs

### Generating PDF/Excel files
Now it is time, to create your own software. We want to build a microservice, that delivers football info as Excel or PDF files.

#### Concepts covered
* [Apache POI library](https://poi.apache.org/)
* How to handle out streams in REST controllers see [example](https://github.com/starwit/sbom-report-generator)

#### Tasks
* create new app and add all necessary dependencies, or use [Spring Initializr](https://start.spring.io/)
* Output league report from last example as PDF or Excel file