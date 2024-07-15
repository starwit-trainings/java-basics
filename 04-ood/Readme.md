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