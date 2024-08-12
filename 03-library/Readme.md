# Introduction to Java libraries

Writing everythin on your own is neither realistic nor advisable. This section will thus provide examples, for how Java code can be structured and how you can use external libraries. For examples we will use the following libraries:
* Apache Commons https://commons.apache.org/

In the Java eco-system literally millions of libraries are available. To get an idea of many libraries are available browse [Maven Central](https://mvnrepository.com/).

## Example list

### Apache Commons Example
This example introduces a proven library and shows, how to use it. Execute the following commands:
```bash
    cd commons
    mvn clean package
    java -jar target/commons.jar
```

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
 