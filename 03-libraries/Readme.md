# Introduction to Java libraries

Writing everything on your own is neither realistic nor advisable. Maturity is a very important attribute of code - the more a piece of code has been used, the more it has been tested.

This section will thus provide examples for how Java code can be structured and how you can use external libraries. In order to manage those libraries (aka dependencies), Maven as a tool is introduced. While we have been using Maven since chapter 01, we have so far largely ignored what it does and how it works.

In the Java eco-system literally millions of libraries are available. To get an idea of how many libraries are available browse [Maven Central](https://mvnrepository.com/).

## Code Examples

### 01 - Maven (Re)introduction
Maven is a tool to manage dependencies and to define build/release processes. It is a proven and quite powerful tool. No software project should be built without a tool like Maven. So far you have "just" used it. Now it is time to dive into some details.
This example will introduce you to some (basic) features of Maven.

#### Concepts covered
Packaging software is about managing complexity and it covers the following concepts:
* [Dependency Management](https://maven.apache.org/guides/introduction/introduction-to-dependency-mechanism.html)
* [Build Management](https://maven.apache.org/guides/introduction/introduction-to-the-lifecycle.html)
* [Continuously building software](https://www.redhat.com/en/topics/devops/what-is-ci-cd)
* [Log4J](https://howtodoinjava.com/log4j2/useful-conversion-pattern-examples/) - output of your application that is meant, to understand it's state, should be done with a logging framework.

#### Tasks
* Run example with phases: compile, test, package, install (i.e. `mvn PHASE1`)
* Observe the console output and the results in target folder, also check content of HOME_DIR/.m2
* Check Maven's configuration in the `pom.xml`. Which plugins are configured and to what purpose?
* One thing Maven is great at is to track software bill of materials - add [CycloneDX plugin](https://github.com/CycloneDX/cyclonedx-maven-plugin) and execute it

### 02 - Apache Commons Text
This example introduces the Apache commons collection of libraries and shows how to use them. Check out this vast lib collection here https://commons.apache.org/. In this section we will specifically use apache-commons-text which contains more advanced ways to work with text, i.e. strings.

To run example, execute the following commands:
```bash
    cd 01-commons

    # Either compile, package and run .jar
    mvn clean package
    java -jar target/control.jar

    # or just compile and run in one command
    mvn compile exec:java

    # Alternatively you can use your IDE to run the main class
```

#### Concepts covered
* [Java packages](https://www.w3schools.com/java/java_packages.asp) How to manage larger blocks of code and how to address objects in libraries
* How to work with libraries, that are downloaded via dependency management
* [Javadoc](https://en.wikipedia.org/wiki/Javadoc) how to use Java's documentation system
* [Working with Strings](https://www.w3schools.com/java/java_strings.asp) More tricks to work with strings in Java

#### Tasks
* Review the code, run it and observe its output
* Browse JavaDoc for `commons-text`: https://commons.apache.org/proper/commons-text/apidocs/index.html
* Play with the two strings and try various combinations
* Rewrite program, to get both strings as a CLI parameter
* Hint: You can pass commandline arguments to the program using `java -jar JARFILE arg1 arg2` or `mvn compile exec:java -Dexec.args="arg1 arg2"`

### 03 - Apache Commons CSV
Now we will take a look at the csv library. For demonstration purposes there is a sample CSV file in `data/bundesliga_clubs.csv` that you can work with.

#### Tasks
* Review the code, run it and observe its output
* Rewrite program, to provide CSV file location as a CLI parameter
* Change the output, such that one line only contains the club name. The league should instead be printed as a divider (i.e. `--- LEAGUE 1 ---`).
* Football clubs are hard to spell out correctly. Implement a simple search that uses one of the string similarity metrics from chapter 01 to find the best match. The search input should be another optional CLI parameter. If the second parameter is given, it shall be used as a search term to find the best match. If it is not given, the program shall print all clubs as before.
* Bonus: Print the three best matches in descending order.

### 04 Apache Commons CLI
Now we will create a Maven project from scratch (you may have noticed that there is no `04-*` code directory, this is why).
As you just learned how to add a library to your software, create a new folder called `04-commons-cli`.

#### Tasks
* create a new project, you can let Maven help you (see [documentation](https://maven.apache.org/archetypes/maven-archetype-quickstart/)):
```bash
    mvn archetype:generate -DarchetypeGroupId=org.apache.maven.archetypes \
        -DarchetypeArtifactId=maven-archetype-quickstart \
        -DarchetypeVersion=1.5 \
        -DjavaCompilerVersion=21
```
* Add commons CLI as a dependency by adding the corresponding dependency entry to your `pom.xml` (Find the dependency on https://mvnrepository.com/)
* Implement parameter handover using Apache Commons CLI. The program shall accept the following parameters:
    * -f set CSV file location from last example (just copy the code for printing the CSV file from the last example)
    * -t prints time and date at program start
    * -h prints info and parameter help
 