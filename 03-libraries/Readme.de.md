# Einführung in Java-Bibliotheken

Alles selbst zu programmieren ist weder realistisch noch ratsam. Die Reife eines Codes ist ein sehr wichtiger Aspekt – je mehr ein Stück Code verwendet wurde, desto mehr wurde es getestet.

Dieser Abschnitt zeigt Beispiele, wie Java-Code strukturiert werden kann und wie externe Bibliotheken genutzt werden können. Um diese Bibliotheken (auch Abhängigkeiten genannt) zu verwalten, wird das Tool Maven eingeführt. Maven verwenden wir bereits seit Kapitel 01, bisher haben wir jedoch weitgehend ignoriert, was es tut und wie es funktioniert.

Im Java-Ökosystem gibt es buchstäblich Millionen von Bibliotheken. Um einen Eindruck davon zu bekommen, schauen sie bei [Maven Central](https://mvnrepository.com/) vorbei.

## Code-Beispiele

### 01 - Maven (Wieder-)Einführung
Maven ist ein Tool zur Verwaltung von Abhängigkeiten und zur Definition von Build-/Release-Prozessen. Es ist ein bewährtes und sehr leistungsfähiges Werkzeug. Kein Softwareprojekt sollte ohne ein Tool wie Maven gebaut werden. Bisher haben sie Maven "nur" benutzt. Jetzt ist es an der Zeit, einige Details kennenzulernen.
Dieses Beispiel führt sie in einige (grundlegende) Funktionen von Maven ein.

#### Behandelte Konzepte
Das Verpacken von Software dient der Komplexitätsbewältigung und umfasst folgende Konzepte:
* [Dependency Management](https://maven.apache.org/guides/introduction/introduction-to-dependency-mechanism.html)
* [Build Management](https://maven.apache.org/guides/introduction/introduction-to-the-lifecycle.html)
* [Kontinuierliches Bauen von Software](https://www.redhat.com/en/topics/devops/what-is-ci-cd)
* [Log4J](https://howtodoinjava.com/log4j2/useful-conversion-pattern-examples/) – Die Ausgabe ihrer Anwendung, die dazu dient, den Zustand zu verstehen, sollte mit einem Logging-Framework erfolgen.

#### Aufgaben
* Führen sie das Beispiel mit den Phasen compile, test, package, install aus (z.B. `mvn PHASE1`)
* Beobachten sie die Konsolenausgabe und die Ergebnisse im target-Ordner, prüfen sie auch den Inhalt von HOME_DIR/.m2
* Prüfen sie die Maven-Konfiguration in der `pom.xml`. Welche Plugins sind konfiguriert und zu welchem Zweck?
* Maven ist hervorragend darin, Software-Stücklisten zu pflegen – fügen sie das [CycloneDX-Plugin](https://github.com/CycloneDX/cyclonedx-maven-plugin) hinzu und führen sie es aus.

### 02 - Apache Commons Text
Dieses Beispiel stellt die Apache Commons-Bibliothekensammlung vor und zeigt, wie sie verwendet werden kann. Die umfangreiche Sammlung finden sie hier: https://commons.apache.org/. In diesem Abschnitt wird speziell apache-commons-text verwendet, das erweiterte Möglichkeiten zur Arbeit mit Texten, also Strings, bietet.

Um das Beispiel auszuführen, verwenden sie folgende Befehle:
```bash
    cd 01-commons

    # Entweder kompilieren, paketieren und .jar ausführen
    mvn clean package
    java -jar target/control.jar

    # oder alles in einem Schritt kompilieren und ausführen
    mvn compile exec:java

    # Alternativ können sie die Hauptklasse auch in ihrer IDE ausführen
```

#### Behandelte Konzepte
* [Java-Packages](https://www.w3schools.com/java/java_packages.asp) – Wie größere Codeblöcke verwaltet und wie Objekte in Bibliotheken adressiert werden
* Wie mit Bibliotheken gearbeitet wird, die über das Abhängigkeitsmanagement heruntergeladen werden
* [Javadoc](https://en.wikipedia.org/wiki/Javadoc) – Wie das Dokumentationssystem von Java genutzt wird
* [Arbeiten mit Strings](https://www.w3schools.com/java/java_strings.asp) – Weitere Tricks zur Arbeit mit Strings in Java

#### Aufgaben
* Überprüfen sie den Code, führen sie ihn aus und beobachten sie die Ausgabe
* Durchstöbern sie das JavaDoc für `commons-text`: https://commons.apache.org/proper/commons-text/apidocs/index.html
* Experimentieren sie mit den beiden Strings und probieren sie verschiedene Kombinationen aus
* Schreiben sie das Programm um, sodass beide Strings als CLI-Parameter übergeben werden
* Hinweis: Sie können Kommandozeilenargumente mit `java -jar JARFILE arg1 arg2` oder `mvn compile exec:java -Dexec.args="arg1 arg2"` an das Programm übergeben

### 03 - Apache Commons CSV
Nun sehen wir uns die CSV-Bibliothek an. Zu Demonstrationszwecken gibt es eine Beispiel-CSV-Datei in `data/bundesliga_clubs.csv`, mit der sie arbeiten können.

#### Aufgaben
* Überprüfen sie den Code, führen sie ihn aus und beobachten sie die Ausgabe
* Schreiben sie das Programm um, sodass der Speicherort der CSV-Datei als CLI-Parameter übergeben werden kann
* Ändern sie die Ausgabe so, dass pro Zeile nur noch der Clubname ausgegeben wird. Die Liga soll stattdessen als Trenner ausgegeben werden (z.B. `--- LEAGUE 1 ---`).
* Fußballvereine sind schwer korrekt zu schreiben. Implementieren sie eine einfache Suche, die eine der String-Ähnlichkeitsmetriken aus Kapitel 01 verwendet, um die beste Übereinstimmung zu finden. Die Sucheingabe soll ein weiterer optionaler CLI-Parameter sein. Wenn der zweite Parameter angegeben ist, soll er als Suchbegriff verwendet werden, um die beste Übereinstimmung zu finden. Wenn er nicht angegeben ist, soll das Programm wie zuvor alle Clubs ausgeben.
* Bonus: Geben sie die drei besten Übereinstimmungen in absteigender Reihenfolge aus.

### 04 Apache Commons CLI
Jetzt erstellen wir ein Maven-Projekt von Grund auf (sie haben vielleicht bemerkt, dass es kein `04-*` Codeverzeichnis gibt, daher ist das so).
Da sie gerade gelernt haben, wie man eine Bibliothek zu ihrer Software hinzufügt, erstellen sie einen neuen Ordner namens `04-commons-cli`.

#### Aufgaben
* Erstellen sie ein neues Projekt, Maven kann sie dabei unterstützen (siehe [Dokumentation](https://maven.apache.org/archetypes/maven-archetype-quickstart/)):
```bash
    mvn archetype:generate -DarchetypeGroupId=org.apache.maven.archetypes \
        -DarchetypeArtifactId=maven-archetype-quickstart \
        -DarchetypeVersion=1.5 \
        -DjavaCompilerVersion=21
```
* Fügen sie Commons CLI als Abhängigkeit hinzu, indem sie den entsprechenden Eintrag in ihre `pom.xml` aufnehmen (finden sie die Abhängigkeit auf https://mvnrepository.com/)
* Implementieren sie die Parameterübergabe mit Apache Commons CLI. Das Programm soll folgende Parameter akzeptieren:
    * -f setzt den Speicherort der CSV-Datei aus dem letzten Beispiel (kopieren sie einfach den Code zum Ausgeben der CSV-Datei aus dem letzten Beispiel)
    * -t gibt beim Programmstart Datum und Uhrzeit aus
    * -h gibt Informationen und eine Parameterhilfe aus
