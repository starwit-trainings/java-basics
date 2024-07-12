---
marp: true
paginate: true
theme: default 
header: ![h:35](imgs/starwit.png)
footer: 'Starwit Technologies GmbH | Java Basics | Overview'
---
<!-- _class: lead -->

# Java Basics

An introduction to the Java Programming Language

---

# Chapter 01 - Setup & Preparation
 * Setting up dev environment
 * Run hello world
 * How does compiling work?
 * Git & Checkout
 * Tooling

## Tasks
 * Run examples details see [here](01-setup/Readme.md)
 * Run each example from your IDE
 * Debug each example from your IDE
 * Execute tasks for each example
---
# Chapter 02 - Java

This section contains an introduction into the Java programming language. Next to the obligatory hello world moment, it shall also introduce base concepts of Java's syntax.

 * History
 * The Java Virtual machine
 * Java's core concepts
 * Standard library
 * Syntax introduction
---
# Java's History
* Compile once, run everywhere
* Running apps on servers
* Intermediary code
* Three decades of optimization
* OpenJDK & Java's release cycle
---
## The Java virtual machine
Which runs everything, has been around forever and will become your best friend.
![width:700px](imgs/JvmSpec7.png)
##### By Michelle Ridomi - Own work, CC BY-SA 4.0, https://commons.wikimedia.org/w/index.php?curid=35963523

---
## Java's core concepts
* Static typing
* Garbage Collection
* Class loading
* References (vs pointers)
* Packages

---
## Syntax Introduction
* Keywords
* Operators
* Basic data types
* Control flow
* Arrays 
* Methods
* Static objects/methods
* CLI Parameters

### Tasks
 * Run examples details see [here](02-java-intro/Readme.md)
 * Run each example from your IDE
 * Debug each example from your IDE
 * Execute tasks for each example

---
# Chapter 03 - Libraries
* Packages revisited
* Dependency Management
* Maven
* How to read JavaDoc
* Example libraries

### Tasks
---
# Chapter 04 - Object Oriented Development
* OOD Concept
* Static vs object attributes
* Inheritance
* Abstract Classes
* Interfaces
* Polymorphy

### Tasks

---
# Chapter 05 - Advanced Java Concepts
* Exceptions
* Unit tests
* Lambda functions
* Collection Framework
* Working with files
* Property files
* Observing JVM doing its thing

### Tasks

---
# Chapter 06 - A larger example
* Let's build a football manager
* Entity representation
* Implementing functions

### Tasks

---
# Chapter 07 - Outlook
* HTTP and network concepts
* REST services
* Defining APIs
* First glimps Spring Boot

### Tasks

---
# License
All code examples in this repository are published under AGPL 3.0. License text can be found [here](LICENSE).

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
  font-size: 0.7rem;
  color: #bbb;
}
section.lead {
  text-align: center;
  margin-bottom: 40px;
}
section {
  font-size: 1.2rem;
}
section.lead h1 {
  font-size: 2.5rem;
  font-weight: 600;
}
section.linked footer {
  display: none;
}
section.linked header {
  display: none;
}
section.quote {
  font-size: 1.0rem;
  text-align: center;
  font-style: italic;
  color: #555;
}

h1 {
  font-size: 2.5rem;
  font-weight: 500;
  color: #2B5A6A;
}
h2 {
  font-size: 1.8rem;
  font-weight: 400;
  color: #333;
  margin-top: 30px;
  margin-bottom: 15px;
  text-transform: uppercase;
}
h5 {
  font-size: 0.7rem;
  font-weight: 100;
  color: #2B5A6A;
}
a {
  color: #3A9FC1;
}
a:hover {
  color: #1E708B; 
  text-decoration: underline; 
}

</style>