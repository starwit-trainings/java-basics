# Introduction object orientation in Java

Modeling problem domains with objects has proven to be a powerful concept to write good software. In this section we will learn how Java deals with classes and objects. 

## Example list

### Football representing class hierachy
This example introduces a set of classes, representing a football league. Execute the following commands:
```bash
    cd football
    mvn clean package
    java -jar target/football.jar
```

#### Tasks
* Run app
* create a class definition for all four csv files in folder data
* parse all of them and create according lists with entries
* make lists holding parsed objects as object variables
* make file location CLI parameters
* Add SizeInterface to AbstractEntity and implement method in all classes accordingly
* add Serializable interface to classes - what does that do?
* implement function, that returns LeagueEntity for given Club - change method signature accordingly
* Can you think of a better way, to handle this?


### Working with stream API
Stream API is a library in Java that helps you working with lists, arrays, ... You can filter elements or do something for each element. One of the great advantages is, that those operations can be executed in parallel. If applicable, this can accelerate you software drastically.
__Note__: Please consider looking into chapter collections in the next section, before you try to solve tasks here.

```bash
    cd football_streams
    mvn clean package
    java -jar target/football-streams.jar
```

#### Tasks
* Run app
* get your parsing methods from last example
* ClubEntities hold an id for LeagueEntity -> let's create a proper object reference using map function, replace static list with parsed leagues from CSV file
* Now connect all Entities with proper references