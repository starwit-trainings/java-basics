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

### Lambda Functions
Lambdas are a leight weight version of Java methods. They are very handy when doing stuff in large data structures. Usually lambda functions implement only short code blocks. However their syntax can be challenging. So this example provides guidance on how to use them.
```bash
    cd lambda
    mvn clean package
    java -jar target/lambda.jar
```

#### Tasks
* Run example and make sure you understand everything
* Let's see if you understood lambdas:
  * Create a functional interface with a function that takes an integer as argument
  * Create two implementations true if divisible by three, compute exponential of base 2
  * use both functions in a forEach loop on integer array

### Generics
Generics are a very powerful extension of Java object system. In fact without generics it is hard to make use of any library in Java. So this example shows you how to use Generics to write code for a league system, that can be used for any kind of sport.

```bash
    cd generics
    mvn clean package
    java -jar target/generics.jar
```

#### Tasks
* Run example
* Add attributes to football club and league entity. Extend league report
* Add player and game entity - any idea how we further generalize code?
* Now let's create a complete different league of chess playing clubs

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

