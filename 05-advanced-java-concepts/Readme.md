# Advanced Java Concepts

Java has a lot of helpful and interesting features. Some are related and some are part of Java's standard library. This section explores some of those features.

## Example list

### Java's Collection Framework
This example introduces Java's collection framework. Execute the following commands:
```bash
    cd collection
    mvn clean package
    java -jar target/collection.jar
```

#### Tasks
* Adapt implementation such, that getting size of club list works always. Hint: empty lists and constructors
* Discussion: Are lists a good basis, to sort entries? Which problems, do you see?
* Take your parsing impl from last chapter and crete sorted output for all lists
* Look at countClubsPerLeague method - can you implement same functionality using an array?
* Write a method, that searches for "SV", "SC" and "FC" and counts how often club names start with that prefix
* Write a method, that extracts prefix from all club names (== split at first white space) and put result in a list of strings

### Exceptions
### Unit Tests
### Property Files
### Writing & Reading from Files