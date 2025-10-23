# Setup-Beispiele

In diesem Abschnitt finden Sie zwei einfache Hello-World-Anwendungen (mit und ohne Maven),\
die Ihnen beim Einrichten Ihrer Entwicklungsumgebung helfen sollen.

## Beispiele

### Einfaches Hello World
Keine Softwareentwicklungs-Vorlesung kann ohne ein Hello-World-Beispiel beginnen.\
Wir starten mit der einfachsten Möglichkeit, ein Stück Java-Code auszuführen.

Führen Sie die folgenden Befehle aus:
```bash
    cd 01-hello-world-plain

    # Compile
    javac HelloWorld.java

    # Run (beachte das fehlende .class)
    java HelloWorld
```

### Maven-basiertes Hello World
Kein echtes Softwareprojekt verwendet Maven ohne ein Build-System (da es wichtige Funktionen wie Abhängigkeitsmanagement und eine Projektstruktur bietet).\
Deshalb werden wir ab jetzt Maven verwenden.

```bash
    cd 02-hello-world-mvn

    # Build .jar file (d.h. kompilieren und Anwendung bündeln)
    mvn clean package

    # .jar-Datei ausführen
    java -jar target/hello-world.jar
```

#### Aufgaben
 * Führen Sie beide Anwendungen aus (siehe oben) und beobachten Sie die Ausgabe
 * Bearbeiten Sie etwas in HelloWorld.java und führen Sie `mvn compile` aus, beobachten Sie die Ausgabe
 * Ändern Sie die Ausgabe auf drei verschiedene Nachrichten Ihrer Wahl
 * Führen Sie `mvn test` aus und beobachten Sie die Ausgabe
 * Sehen Sie sich die [Logging-Konfiguration](02-hello-world-mvn/src/main/resources/log4j2.xml) an und ändern Sie den Namen der Log-Datei
 * Sie werden feststellen, dass die Log-Datei nach dem Programmablauf leer ist. Versuchen Sie, das zu ändern.
