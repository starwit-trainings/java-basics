# 02 Language Introduction

In this section you will find a number of simple examples that will introduce the Java programming language. The goal is to cover the most basic features and help you to start developing your own software as quickly as possible.

## Code Examples

### 01 - Control Flow
This example demonstrate some of Java's features to make decisions and control your program's flow. Execute the following commands:
```bash
    cd 01-control
    mvn clean package
    java -jar target/control.jar

    # From now on you can also just run this to execute the code in one step without building a .jar first (this requires some setup in your pom.xml which I have done for you)
    mvn compile exec:java

    # Alternatively you can use your IDE to run the main class de.starwit.Control
```

#### Concepts covered
* [if/else](https://www.w3schools.com/java/java_conditions.asp) -> based on variables or expressions, your program can decide different ways to act
* [switch/case](https://www.w3schools.com/java/java_switch.asp) -> if you have a multitude of possible choices based on the value of a variable, this helps you defining them in an easy to understand way
* loops
    * [for](https://www.w3schools.com/java/java_for_loop.asp) -> classic C-style for-loop to run from start value (e.g 0) until a predefined condition is met (like length of an array), including a statement to increase/decrease the loop variable
    * [for(each)](https://www.w3schools.com/java/java_foreach_loop.asp) -> Java's way of looping over every element in arrays/collections/...
    * [while](https://www.w3schools.com/java/java_while_loop.asp) -> Run a loop for as long a value/expression is true (this one can lead to infinite loops, be careful)

#### Tasks
* Run code and observe its output
* Modify the if/else decision to trigger else branch
* Implement a countdown from 10 to 0 using a for loop
* Implement a loop that prints all even numbers between 20 to 30 (inclusive) using a while loop
* Play with the new switch expression syntax (https://docs.oracle.com/en/java/javase/21/language/switch-expressions-and-statements.html)

### 02 - Methods and Parameters
In order to break down software into manageable pieces methods (or functions) are a key concept and handing over parameters is essential to make them reusable. This example project shows you how to do this. Also we'll finally write some simple tests to verify our code works as expected. Turns out, methods are also essential to write testable code.

#### Concepts covered
* [Java methods](https://www.w3schools.com/java/java_methods.asp) Java's core concept to break code into manageable blocks
* [Parameters in Methods](https://www.w3schools.com/java/java_methods_param.asp) How to deal with parameters for methods.
* [JUnit Testing](https://www.geeksforgeeks.org/advance-java/introduction-of-junit/) Writing simple tests to verify your code works as expected.

#### Tasks
* Run app and observe output
* Look at the existing methods and their signatures and understand how parameters are handed over and used
* Extract the logic to read a number from user input into a separate method readInput() and returns the read integer
* Turn this application into a simple calculator that adds two numbers from user input and prints the result
* Have a look at the existing test [testGetFive()](02-methods/src/test/java/de/starwit/MethodsTest.java#L14) and understand how it works, then change the return value of the tested function [getFive()](02-methods/src/main/java/de/starwit/Methods.java#L62) and run `mvn test`
* Write some new tests for methods you have created (at least for the existing add() method)

### 03 - Data Types and Variables
Storing data in variables is essential for any programming language. We have already done this with numbers (i.e. integers) in the preceding examples. There are however many more interesting data types to be stored. This example provides help to understand Java's build-in types and how you use them. [Here](https://www.w3schools.com/java/java_data_types.asp) is an overview of some primitive types.

#### Concepts covered
* [Java's (primitive) datatypes](https://www.w3schools.com/java/java_data_types.asp)
* [Type conversions](https://www.w3schools.com/java/java_type_casting.asp) How to convert types and which rules are applied implicitly
* [Operators](https://www.w3schools.com/java/java_operators.asp) 
* [Arrays](https://www.w3schools.com/java/java_arrays.asp) which allows you, to store multiple things of the same type
* [Scopes](https://www.w3schools.com/java/java_scope.asp) How scopes define, where variables can be used and where not.

__Please note__ As Java is an object oriented programming language, it's type system can be extended and it is in fact the much more interesting part of the language :)

#### Tasks
* Run app
* Modify dataTypes/moreDataTypes method, such that StringBuffer output separates values
* Write a method, that in/decreases all integer types to its respective maximum/minimum
* Enhance calculating method by all [arithmetic operators](https://www.w3schools.com/java/java_operators.asp)
* Enhance array method with an array that holds random integers, after that every number in the array shall be increased by 1, except if the value is greater or equal 1000 [Hint for random numbers](https://www.geeksforgeeks.org/generating-random-numbers-in-java/)
* Write a method, that collects more than one input, checks if input is an integer and put all integers into an array. After completion - how do you know? - array shall be printed (see method multiple things)
* Can you implement output from last task, using a while loop?

### Parameters and Methods
In order to break down software into manageable pieces, handing over parameters is essential. This example project shows you, how to do this on program start and with methods.

#### Concepts covered
* [Java methods](https://www.w3schools.com/java/java_methods.asp) Java's core concept to break code into manageable blocks
* [Parameters in Methods](https://www.w3schools.com/java/java_methods_param.asp) How to deal with parameters for methods.
* [Overloading Methods](https://www.w3schools.com/java/java_methods_overloading.asp) On the magic, that multiple methods can have the same name and yet do something different.

#### Tasks
* Run app with various parameters
* output number of handed over parameters
* Write a method, that checks for every parameter if it is a string or integer
* Put all integer params in an array, write a method that takes this array as input and results sum of all elements
* write a method that takes first parameter and switch cases over values calling a method for each case. Choose how many cases you want to distinguish
* Look at method _returnParameterExample_, create two other methods with the same name. On shall take _double_ and the other _int_ as input parameters. Both shall return the sum of it's two parameters
* move all static methods to FirstClass definition and call them from there
* __Bonus challenge__: If first parameter is an integer, this shall be taken as an input for a method, that asks for as many user inputs as the integer's value. All input values shall be stored in an array. Inform user on how many items are still necessary to input.
