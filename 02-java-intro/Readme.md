# Introduction to Java

In this section you will find a number of simple examples, that will introduce the Java programming language. Goal is to cover the most basic features and help you, to start developing your own software as quickly as possible.

## Example list

### Controlling what's happening
This example demonstrate some of Java's features, to make decisions and control your program's flow. Execute the following commands:
```bash
    cd control
    mvn clean package
    java -jar target/control.jar
```

#### Concepts covered
This example has examples for the following language features:
* [if/else](https://www.w3schools.com/java/java_conditions.asp) -> based on variables or expressions, your program can decide different ways to act
* [switch/case](https://www.w3schools.com/java/java_switch.asp) -> if you have a multitude of possible choises, based on the value of a variable, this helps you defining them in an easy to understand way.
* loops
  * [for](https://www.w3schools.com/java/java_for_loop.asp) -> classic program loop to run from start value (e.g 0) to an end value (like length of an array)
  * [for(each)](https://www.w3schools.com/java/java_foreach_loop.asp) -> Java's way of looping over every element in arrays/collections/...
  * [while](https://www.w3schools.com/java/java_while_loop.asp) -> Run a loop for as long a value/expression is true

#### Tasks
 * Run app and test with various inputs
 * add a switch case to input method, selecting numbers 1,2,3
 * write four methods one for each above switch cases and one for default
 * modify the method for case three that outputs 10 times a message
 * If input is a number
    * call makeDecision with that number - modify method signature
    * call forloops/whileloops methods with input as parameter, use param as loop condition
    * Write a method, that runs a for loop as often as _input_ but breaks if input is divisable by 11 [hint break](https://www.w3schools.com/java/java_break.asp) [hint modulus](https://www.w3schools.com/java/java_operators.asp)
    * Write a method, that runs a while loop, but dismiss current iteration, if input is divisable by 11
* Rewrite method readingInput such, that input is returned as a value, if input is a number. Remove log output from that method and move that output to main method.

### On data types
Storing data in variables is essential for any programming language. This example provides help, to understand Java's build-in types and how you use them. [Here](https://www.w3schools.com/java/java_data_types.asp) is an overview of primitive types.
```bash
    cd data
    mvn clean package
    java -jar target/data.jar
```
#### Concepts covered
This example has examples for the following language features:
* [Java's (primitive) datatypes](https://www.w3schools.com/java/java_data_types.asp)
* [Type conversions](https://www.w3schools.com/java/java_type_casting.asp) How to convert types and which rules are applied implicitly
* [Operators](https://www.w3schools.com/java/java_operators.asp) 
* [Arrays](https://www.w3schools.com/java/java_arrays.asp) which allows you, to store multiple things of the same type

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
```bash
    cd params
    mvn clean package
    java -jar target/params.jar param1 9 param3
```

#### Concepts covered
This example has examples for the following language features:
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
