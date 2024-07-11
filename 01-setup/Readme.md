# Setup Examples

In this section you will find a number of simple examples, that shall help you, setting up your development environment.

## Example list

### Hello World
No software development lecture can start without a hello word example. So execute the following commands:
```bash
    cd hello-world
    mvn clean package
    java -jar target/hello-world.jar
```

#### Tasks
 * Edit something in App.java and run __mvn compile__  and observe output
 * Change output to three different messages of your choosing
 * run __mvn test__ and observe output
 * look into [logging config](hello-world/src/main/resources/log4j2.xml) and change name of log file