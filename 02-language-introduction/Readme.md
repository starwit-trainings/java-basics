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
* Review the code, run it and observe its output
* Modify the if/else decision to trigger else branch
* Implement a countdown from 10 to 0 using a for loop
* Implement a loop that prints all even numbers between 20 to 30 (inclusive) using a while loop
* Bonus: Play with the new switch expression syntax (https://docs.oracle.com/en/java/javase/21/language/switch-expressions-and-statements.html)

### 02 - Methods and Parameters
In order to break down software into manageable pieces methods (or functions) are a key concept and handing over parameters is essential to make them reusable. This example project shows you how to do this. Also we'll finally write some simple tests to verify our code works as expected. Turns out, methods are also essential to write testable code.

#### Concepts covered
* [Java methods](https://www.w3schools.com/java/java_methods.asp) Java's core concept to break code into manageable blocks
* [Parameters in Methods](https://www.w3schools.com/java/java_methods_param.asp) How to deal with parameters for methods.
* [Overloading Methods](https://www.w3schools.com/java/java_methods_overloading.asp) On the magic, that multiple methods can have the same name and yet do something different.
* [JUnit Testing](https://www.geeksforgeeks.org/advance-java/introduction-of-junit/) Writing simple tests to verify your code works as expected.

#### Tasks
* Review the code, run it and observe its output
* Look at the existing methods and their signatures and understand how parameters are handed over and used
* Extract the logic to read a number from user input into a separate method readInput() and returns the read integer
* Turn this application into a simple calculator that adds two numbers from (separate) user inputs and prints the result
* Have a look at the existing test [testGetFive()](02-methods/src/test/java/de/starwit/MethodsTest.java#L14) and understand how it works, then change the return value of the tested function [getFive()](02-methods/src/main/java/de/starwit/Methods.java#L62) and run `mvn test`
* Write some new tests for methods you have created (at least for the existing add() method)
* Bonus: Make the calculator handle subtraction, multiplication and division as well.
* Bonus: Make the calculator parse a simple expression like "5 + 3" from a single user input line (like a real calculator would).

### 03 - Data Types and Variables
Storing data in variables is essential for any programming language. We have already done this with numbers (i.e. integers) in the preceding examples. There are, however, many more interesting data types to be stored. This example provides help to understand Java's build-in types and how to use them. [Here](https://www.w3schools.com/java/java_data_types.asp) is an overview of some primitive types.

#### Concepts covered
* [Java's (primitive) datatypes](https://www.w3schools.com/java/java_data_types.asp)
* [Type conversions](https://www.w3schools.com/java/java_type_casting.asp) How to convert types and which rules are applied implicitly
* [Operators](https://www.w3schools.com/java/java_operators.asp) 
* [Arrays](https://www.w3schools.com/java/java_arrays.asp) which allows you, to store multiple things of the same type
* [Scopes](https://www.w3schools.com/java/java_scope.asp) How scopes define, where variables can be used and where not.

__Please note__ As Java is an object oriented programming language, it's type system can be extended and it is in fact the much more interesting part of the language :)

#### Tasks
* Review the code, run it and observe its output
* Read a sentence as string (should contain multiple words) from user input and print every word on a separate line
* Have a look at the arrays() method, understand how arrays are defined, filled and accessed
    * Add a for loop that prints the array in reverse order
    * Print a random array element (hint: use Math.random() to generate a random index)
    * Extract the array initialization part into a separate method initializeStringArray() and make the length variable
* Read a number of integers from user input (e.g. "2 3 8 2 4 1") and print the following values: minimum, maximum, sum, average
* Bonus: Look at the automatic type conversion rules. Can you imagine any problems that may arise? Try to come up with a demonstration.

### 04 - Notes App
In order to finally do something useful, we will now build a primitive notes app, using all the knowledge we have so far =)

#### Tasks
* The program should behave the following way
    * On start the user is prompted to input a number, which will determine the capacity of the notebook (e.g. 10 -> can hold 10 string entries)
    * Then the user can start using the notes app by inputting commands one by one (i.e. COMMAND -> _ENTER_ -> OUTPUT -> COMMAND -> _ENTER_ -> OUTPUT etc.)
* Available commands
    set N STRING (sets the string at position N to STRING)
    get N (prints the string at position N)
    print (prints all entries, line by line, with indizes)
* This starts being a somewhat complex application, so we start writing tests to make sure it works (write at least one test for a command)
* Hint: Have a look at [String::split()](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html#split-java.lang.String-)
* Bonus: Remove the prompt for capacity, add the commands "add STRING" and "delete N", therefore making the notebook of variable / dynamic size (do not use collections!). It can now magically store as many entries as you like! (until your computer runs out of memory of course)
