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

#### Concepts covered
Saving data in sets, lists or maps are everyday tasks when developing software. Java thus offers implementations of the most important data structures. See the following introductions to understand, how they work

* [Lists](https://www.geeksforgeeks.org/list-interface-java-examples/)
* [Maps](https://www.geeksforgeeks.org/map-interface-java-examples/)
* [Sets](https://www.geeksforgeeks.org/set-in-java/)

__Note:__ The Java Collection contains a lot more data structures. See [here](https://www.geeksforgeeks.org/collections-in-java-2/) for a complete list and [here](https://en.wikipedia.org/wiki/Java_collections_framework) for a diagram containing class relations.

#### Tasks
* Adapt implementation such, that getting size of club list works always. Hint: empty lists and constructors
* Discussion: Are lists a good basis, to sort entries? Which problems, do you see?
* Take your parsing impl from [last chapter](../04-ood/Readme.md) and crete sorted output for all lists
* Look at countClubsPerLeague method - can you implement same functionality using an array?
* Write a method, that searches for "SV", "SC" and "FC" and counts how often club names start with that prefix
* Write a method, that extracts prefix from all club names (== [split](https://www.w3schools.com/java/ref_string_split.asp) at first white space) and put result in a list of strings

### Lambda Functions
Lambdas are a leight weight version of Java methods. They are very handy when doing stuff in large data structures. Usually lambda functions implement only short code blocks. However their syntax can be challenging. So this example provides guidance on how to use them.
```bash
    cd lambda
    mvn clean package
    java -jar target/lambda.jar
```

#### Concepts covered
An introduction to Lambda functions can be found [here](https://www.w3schools.com/java/java_lambda.asp).

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

#### Concepts covered
[Generics](https://en.wikipedia.org/wiki/Generics_in_Java) are an essential part of Java's class/object system. See [OOD section](../04-ood/Readme.md) and list example above, to understand, how generics blend in.

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

#### Concepts covered
An overview of Java's concept for exceptions can be found [here](https://www.w3schools.com/java/java_try_catch.asp).

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

#### Concepts covered
* A general introduction to unit tests can be found at [Wikipedia](https://en.wikipedia.org/wiki/Unit_testing). 
* See [here](https://www.atlassian.com/continuous-delivery/software-testing/code-coverage) how coverage of your code by unit tests is taken care of.
* Framework used for this example is [jUnit](https://junit.org/junit5/).

#### Tasks
* run example and try various values for assertions
* use assertEquals for testSorting - why is this better?
* Look at class [LeagueUtilities](unit-tests/src/main/java/de/starwit/LeagueUtilities.java) and create a new function, that computes all season matchdays starting from a given date.
* Discussion: Let's consider CSV files from [chapter 04](../04-ood/football/) into this project. How can you unit test data import, when using short extracts from every file?

### Property Files
This example shows you, how to use property files in Java. They are very helpful, to configure Java applications. Execute the following commands:
```bash
    cd property-files
    mvn clean package
    java -jar target/property-files.jar
```

#### Concepts covered
Though a simple concept, make sure, you understand the [concept](https://en.wikipedia.org/wiki/.properties) of property files.

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

#### Concepts covered
* Basic file operations at [W3Schools](https://www.w3schools.com/java/java_files.asp).
* It is a good idea, to review the idea of [abstraction](https://www.w3schools.com/java/java_abstract.asp).

#### Tasks
* Change output to use ; instead of ,
* add a header line to produced CSV file.

