# Setup Examples

In this section you will find a number of simple examples, that shall help you, setting up your development environment.

## 1. Setup

### Installation

* **Check, if Java is already installed with command line: `java --version`**
  * If not present, install Java JDK:
    * Download JDK from https://adoptium.net/temurin/releases/ and extract zip/tar file
    * add Java bin-directory to environment variable PATH
* **Check if Maven is already installed with commandline: `mvn --version`**
  * If not present, install Maven:
    * Download Maven from https://maven.apache.org/download.cgi and extract zip/tar file
    * add Maven bin-directory to environment variable PATH
* **Check if git is available with command line: `git --version`**
  * If not present, install git:
    * https://git-scm.com/downloads/win
* **Check if IDE is available (e.g. execute `code` on command line)**
  * If not present
    * install IDE like Visual Studio Code https://code.visualstudio.com/
    * add Java Plugins:Extension Pack for Java

### 2. Execute Quiz Program

#### 1.1 Run and debug Quiz via IDE

Try to run the Quiz.java program via your IDE. Set a breakpoint and start Quiz.java in debug mode

#### 1.2 Run Quiz via command line

As already mentioned in the slides, JDK or JRE comes with tools to execute java programs. Run your Quiz program in different ways as described:

Root folder: ```quiz```
Compile in bytecode:

```bash
mkdir classes
javac src/main/java/de/starwit/Quiz.java -d classes
```

Execute Java program:

```bash
java src/main/java/de/starwit/Quiz.java
cd classes
java de.starwit.Quiz
```

Create and execute archive:

```bash
jar --create --file foo.jar --main-class de.starwit.Quiz -C classes .
java -jar foo.jar
```

Answer the Questions.

### 3. Execute  and Change Hello World

No software development lecture can start without a hello word example. So execute the following commands:

```bash
    cd hello-world
    mvn clean package
    java -jar target/hello-world.jar
```

* Edit something in App.java and run __mvn compile__  and observe output
* Change output to three different messages of your choosing
* run __mvn test__ and observe output