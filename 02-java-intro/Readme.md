# Introduction to Java

In this section you will find a number of simple examples, that will introduce the Java programming language.

## Example list

### Controlling what's happening
This example demonstrate some of Java's features, to make decisions and control your program's flow. Execute the following commands:
```bash
    cd control
    mvn clean package
    java -jar target/control.jar
```

#### Tasks
 * Run app and test with various inputs
 * add a switch case to input method, selecting numbers 1,2,3
 * write four methods one for each above switch cases and one for default
 * modify the method for three that outputs 10 times a message
 * 

### On data types
Storing data in variables is essential for any programming language. This example provides help, to understand Java's build-in types and how you use them.
```bash
    cd data
    mvn clean package
    java -jar target/data.jar
```

#### Tasks
 * Run app
 * Write a method, that creates StringBuffer output with separating all values
 * Write a method, that in/decreases all integer types to its respective maximum/minimum
 * Enhance calculating method by all [arithmetic operators](https://www.w3schools.com/java/java_operators.asp)
 * Enhance array method with an array that holds random integers, after that every number in the array shall be increased by 1, except if the value is greater or equal 1000

### Parameters and Methods
In order to break down software into manageable pieces, handing over parameters is essential. This example project shows you, how to do this on program start and with methods.
```bash
    cd params
    mvn clean package
    java -jar target/params.jar param1 9 param3
```

#### Tasks
 * Run app with various parameters
 * output number of handed over parameters
 * Write a method, that checks for every parameter if it is a string or integer
 * Put all integer params in an array, write a method that takes this array as input and results sum of all elements
 * move all static methods to FirstClass definition and call them from there
