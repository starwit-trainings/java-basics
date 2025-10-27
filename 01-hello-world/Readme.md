# 01 - Hello World

In this section you will find two simple hello world applications (with and without Maven)\
that shall help you setting up your development environment.

## Code Examples

### Plain Hello World
No software development lecture can start without a hello word example.\
We'll start with the simplest way to run a piece of Java code.

Execute the following commands:
```bash
    cd 01-hello-world-plain

    # Compile
    javac HelloWorld.java

    # Run (note the missing .class)
    java HelloWorld
```

### Maven-based Hello World
No actual software project uses Maven without a build system (as it provides essential features like dependency management and a project structure).\
That is the reason why from now on we will use Maven.

```bash
    cd 02-hello-world-mvn

    # Build .jar file (i.e. compile and bundle application)
    mvn clean package

    # Run .jar file
    java -jar target/hello-world.jar
```

#### Tasks
 * Run both applications (see above) and observe output
 * Edit something in HelloWorld.java and run `mvn compile`  and observe output
 * Change output to three different messages of your choosing
 * Run `mvn test` and observe output
 * Look into [logging config](02-hello-world-mvn/src/main/resources/log4j2.xml) and change name of log file
 * Bonus: You'll notice that the log file is empty after the program has run. Try and change that.