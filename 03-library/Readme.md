# Introduction to Java libraries

Writing everything on your own is neither realistic nor advisable. Maturity is a very important attribute of code - the more a piece of code is used, the more it is tested.

This section will thus provide examples, for how Java code can be structured and how you can use external libraries. In order to manage those libraries (aka dependencies), Maven as a tool is introduced. 

In the Java eco-system literally millions of libraries are available. To get an idea of many libraries are available browse [Maven Central](https://mvnrepository.com/). 

## Example list

### Apache Commons Example
This example introduces the Apache commons collection of libraries and shows, how to use it. Check out this vast lib collection here https://commons.apache.org/

To run example, execute the following commands:
```bash
    cd commons
    mvn clean package
    java -jar target/commons.jar
```

#### Concepts covered
This example has examples for the following language features:
* [Java packages](https://www.w3schools.com/java/java_packages.asp) How to manage larger blocks of code and how to address objects in libraries
* How to work with libraries, that are downloaded via dependency management
* [Javadoc](https://en.wikipedia.org/wiki/Javadoc) how to use Java's documentation system
* [Working with Strings](https://www.w3schools.com/java/java_strings.asp) More tricks to work with strings in Java

#### Tasks
* Browse JavaDoc: https://commons.apache.org/proper/commons-text/apidocs/index.html
* Play with the two strings and try various combinations
* Rewrite program, to get both strings as a CLI parameter
* Rewrite program, to provide CSV file location as a CLI parameter - parameter check shall be in a separate method
* Use string parameters and check every entry if name is equal to one of the params

### Apache Commons CLI
This example shall be build by you. As you just learned how to add a library to your software, create a new folder called apachecli and copy content of last example. Rename all necessary fields in pom.xml and add [Apache CLI](https://commons.apache.org/proper/commons-cli/introduction.html) as a dependency. This example shall except the following parameters:
* -f that holds CSV file location from last example
* -t that prints time and date
* -h to print info and parameter help

#### Tasks
* create a new project, you can let Maven help you:
    ```java
        mvn archetype:generate -DarchetypeGroupId=org.apache.maven.archetypes 
        -DarchetypeArtifactId=maven-archetype-quickstart 
        -DarchetypeVersion=1.5 
        -DjavaCompilerVersion=21
    ```
* Add commons CLI as a dependency

### Maven Introduction
Maven is a tool to manage dependencies and to define build/release processes. It is a proven and quite powerful tool. No software project should be build without a tool like Maven. This example will introduce you to some (basic) features of Maven.

So far you have "just" used Maven. Now it is time, to dive into some details.
To run example, execute the following commands:
```bash
    cd maven-example
    mvn package
    java -jar target/maven.jar
```

#### Tasks
* Run example with phases: compile, test, package, install
* Observe results in target folder, check also content HOME_DIR/.m2
* Make sure you understand executable jar process - change name of resulting filename
* One thing Maven is great, is to track software bill of materials - add [CycloneDX plugin](https://github.com/CycloneDX/cyclonedx-maven-plugin) and execute it
 