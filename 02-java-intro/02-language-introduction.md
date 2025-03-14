---
marp: true
paginate: true
theme: default 
header: ![h:35](../imgs/starwit.png)
footer: 'Starwit Technologies GmbH | C# | 1. Tools, Setup & .NET'
---

<style>
header {
  text-align: right;
  font-size: 0.7rem;
  color: #bbb;
  margin: 20px;
  left: 0px;
  right: 0px;
  padding-top: 5px;
}
footer {
  font-size: 0.9rem;
  color: #666;
}
section.lead {
  text-align: center;
  margin-bottom: 40px;
}
section.lead h2 {
  font-size: 2.5rem;
}
section {
  font-size: 1.5rem;
}

section.linked footer {
  display: none;
}
section.linked header {
  display: none;
}
section.quote {
  font-size: 0.7rem;
  text-align: center;
  font-style: italic;
  color: #555;
}

h1 {
  position: absolute;
  top: 10px;
  padding-top: 15px;
  text-transform: uppercase;
  font-size: 2.0rem;
  font-weight: 500;
  color: #2B5A6A;
}

h2 {
  font-size: 2.0rem;
  font-weight: 500;
  color: #2B5A6A;
  margin-top: 30px;
  margin-bottom: 15px;
}
a {
  color: #3A9FC1;
}
a:hover {
  color: #1E708B; 
  text-decoration: underline; 
}

</style>
<!-- _class: lead -->
## 2. Language Introduction

---
# Agenda

* Variables, Data Types & Constants
* Control Flow
  * code block
  * condition
  * loops
  * switch
* Arrays
* Operators
* Methods
* Documentation

---
# Language Introduction
## Variables
* A variable:
    * holds a value
    * has a data type
    * is created in a declaration statement
* coding convention for naming: 
    * starting with lower case
    * using camel case


---
# Language Introduction
## Variables - Data Types
Define 
* Size and location in memory
* Data range
* Valid operators

of/for a variable

> all built in types can be found [here](https://learn.microsoft.com/en-us/dotnet/csharp/language-reference/builtin-types/built-in-types)

---
# Language Introduction
## Implicitly typed local variables

* declared without using a type
```csharp
// i is compiled as an int
var i = 5;

// s is compiled as a string
var s = "Hello"
```

## Constants

* using key-word `const`, e.g. `const int myInt = 10`

---
# Language Introduction
## Control Flow
* Codeblock: 
    * contains several lines of code
    * surrounded with `{ }`
* boolean expression: 
    * returns a boolean value
    * operators: <, >, <=, >=, ==, !=

---
# Language Introduction
## Control Flow
* Condition: if statement (if, else if, else)
* Loop: 
    * for
    * foreach
    * while
    * do-while
* Switch: case statement
* break / continue

> more information and code examples can be find [here](https://www.w3schools.com/cs/cs_conditions.php)

---
# Wissensquiz

* Nenne drei grundlegende Datentypen in C#? Gibt es Typen die sich stark ähneln?
* Was passiert, wenn Zahlen den Wertebereich ihres Datentypen übersteigen?
* Du ließt logs von einem Server in London, was musst du bei der Betrachtung der Zeitstempel beachten?
* Welche Möglichkeiten gibt es, in C# Schleifen zu programmieren?

---
# Language Introduction
## Arrays

* can have one or more dimensions

    `string[] cars = {"Volvo", "BMW", "Ford", "Mazda"};`
    `int[,] coordinates = {{1, 2}, {2,3}};`
    `double[] doubleNumbers = new double[5];`
> more information can be find [here](https://www.w3schools.com/cs/cs_arrays_multi.php)

---
# Language Introduction
## Operators

* Arithmetic operators (+ - / * % ++ --) that perform arithmetic operations with numeric operands
* Comparison operators (< > == <= >=) that compare numeric operands
* Boolean logical operators (&& || ! ^ & |) that perform logical operations with bool operands
* Bitwise and shift operators (~ >> << | & >>>) that perform bitwise or shift operations with operands of the integral types
* Equality operators (== !=) that check if their operands are equal or not

> [source](https://learn.microsoft.com/en-us/dotnet/csharp/language-reference/operators/)

---
# Language Introduction
## Methods, Parameters and structuring your code

* methods 
    * are code block which only runs when they are called
    * use parameters to pass data into methods
    * can have a return value or void
    * are declared in a class or struct
* use methods in order to reuse code
* are also called functions


---
# Language Introduction
## Methods, Parameters and structuring your code

```csharp
class SimpleMathExtension
{
    public int DivideTwoNumbers(int number1, int number2)
    {
        return number1 / number2;
    }
}
```

```csharp
class Class_Name
{
    <access modifier> <return type> Method_Name(Parameters)
    {
        //method statements
        return Return_Value;
    }
}
```
---
# Language Introduction
## Main Method
Entry method which is called after start of the app
```csharp
class SimpleMathExtension
{
    static void Main(string[] args)
    {
      int result = DivideTwoNumbers(9, 3);
      Console.WriteLine(result);
    }
    
    public int DivideTwoNumbers(int number1, int number2)
    {
        return number1 / number2;
    }
}
```

---
# Language Introduction
## Method Overloading

```csharp
/**
* Methods has the same name but different parameters
**/
class MethodOverloadExample
{
    public int addNumbers(int number1, int number2)
    {
        return number1 + number2;
    }

    public int addNumbers(int number1, int number2, int number3)
    {
        return number1 + number2 + number3;
    }

    public double addNumbers(double number1, double number2)
    {
        return number1 + number2;
    }
}
```
---
# Language Introduction
## Local Scope Variables

```csharp
public int DivideTwoNumbers(int number1, int number2)
{
    //local scoped variable - only available in method
    int returnValue = number1 / number2; 
    return returnValue;
}
```
## Optional Parameters
```csharp
//number2 is an optional paramenter
public int DivideTwoNumbers(int number1, int number2 = 10)
{
    return number1 / number2; 
}
```
---
# Wissensquiz

* Nenne arithmetische Operatoren. Welche Arten von Operatoren gibt es noch?
* Welche Zugriffsmodifizierer für Methoden sind dir bekannt?
* Wie heißt die Methode, die beim starten eines Projektes ausgeführt wird?
* Was sind lokale Variablen?
* Aus welchen drei Elementen besteht die Signatur einer Methode?

---
# Language Introduction
## Documentation

* use **Logger** and not Console.WriteLine() to be able to redirect output e.g. in files by configuration. See [here](https://raygun.com/blog/c-sharp-logging-best-practices/) for detailed information

* use DocFx to provide api documentation for your programm
  ```bat
  Rem installation
  dotnet tool update -g docfx
  Rem create docfx configuration
  docfx init
  Rem start webserver
  docfx docfx.json --serve
  ```
---
# Wissensquiz
* Für wen schreibst du deinen Code?
* Wann und was würdest du dokumentieren?
* Welche log-Level gibt es?
* Welchen Vorteil haben Logger im Gegensatz zu direkten Consolenausgaben?
