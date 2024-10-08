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
Exceptions are a powerful concept, to deal with things going wrong. And as things always can go wrong, working with exceptions properly is important. To run example, execute the following commands:
```bash
    cd exceptions
    mvn clean package
    java -jar target/exceptions.jar
```
#### Tasks
* run app and observe output
* extract parsing data into a separate method and catch Exception, Hint: _NumberFormatException_
* rename csv file and observe what's happening
* discuss, what are good strategies for this situation

### Unit Tests
Making sure that everything, that worked yesterday, still works today, unit tests are very helpful. To run example, execute the following commands:
```bash
    cd unit-tests
    mvn clean package
    java -jar target/unit-tests.jar
```

#### Tasks
* run example and try various values for assertions
* use assertEquals for testSorting - why is this better?

### Property Files
This example shows you, how to use property files in Java. They are very helpful, to configure Java applications. Execute the following commands:
```bash
    cd property-files
    mvn clean package
    java -jar target/property-files.jar
```
#### Tasks
* add locations for all data files as a property & take over parsing code from collection example
* copy files to another location and test if app with adapted config is still working
* use boolean switch to turn on/off sorting Hint:
  ```java
    boolean isSorting = Boolean.parseBoolean(config.getProperty("data.sort"));
  ```

### Writing & Reading from Files
Writing to files is an every day task and here is an example, that shows you, how write to files in Java. Execute the following commands:
```bash
    cd files
    mvn clean package
    java -jar target/files.jar
```
#### Tasks
* Change output to use ; instead of ,
* add a header line to produced CSV file.

