# 02 Spracheinführung

In diesem Abschnitt finden Sie eine Reihe einfacher Beispiele, die die Programmiersprache Java vorstellen. Ziel ist es, die grundlegendsten Funktionen abzudecken und Ihnen zu helfen, so schnell wie möglich eigene Software zu entwickeln.

## Code-Beispiele

### 01 - Kontrollfluss
Dieses Beispiel demonstriert einige von Javas Möglichkeiten, Entscheidungen zu treffen und den Programmfluss zu steuern. Führen Sie die folgenden Befehle aus:
```bash
    cd 01-control
    mvn clean package
    java -jar target/control.jar

    # Ab jetzt können Sie auch einfach dies ausführen, um den Code in einem Schritt auszuführen, ohne vorher ein .jar zu bauen (dies erfordert etwas Setup in Ihrer pom.xml, das ich für Sie erledigt habe)
    mvn compile exec:java

    # Alternativ können Sie Ihre IDE verwenden, um die Hauptklasse de.starwit.Control auszuführen
```

#### Behandelte Konzepte
* [if/else](https://www.w3schools.com/java/java_conditions.asp) -> Basierend auf Variablen oder Ausdrücken kann Ihr Programm unterschiedliche Wege einschlagen
* [switch/case](https://www.w3schools.com/java/java_switch.asp) -> Wenn Sie viele mögliche Auswahlmöglichkeiten basierend auf dem Wert einer Variablen haben, hilft dies, sie einfach verständlich zu definieren
* Schleifen
    * [for](https://www.w3schools.com/java/java_for_loop.asp) -> Klassische C-Style for-Schleife, um von einem Startwert (z.B. 0) bis zu einer vordefinierten Bedingung zu laufen (wie die Länge eines Arrays), einschließlich einer Anweisung zum Erhöhen/Verringern der Schleifenvariablen
    * [for(each)](https://www.w3schools.com/java/java_foreach_loop.asp) -> Javas Weg, über jedes Element in Arrays/Sammlungen/... zu iterieren
    * [while](https://www.w3schools.com/java/java_while_loop.asp) -> Führt eine Schleife aus, solange ein Wert/Ausdruck wahr ist (kann zu Endlosschleifen führen, seien Sie vorsichtig)

#### Aufgaben
* Überprüfen Sie den Code, führen Sie ihn aus und beobachten Sie die Ausgabe
* Ändern Sie die if/else-Entscheidung, um den else-Zweig auszulösen
* Implementieren Sie einen Countdown von 10 bis 0 mit einer for-Schleife
* Implementieren Sie eine Schleife, die alle geraden Zahlen zwischen 20 und 30 (einschließlich) mit einer while-Schleife ausgibt
* Bonus: Probieren Sie die neue switch-Expressions-Syntax aus (https://docs.oracle.com/en/java/javase/21/language/switch-expressions-and-statements.html)

### 02 - Methoden und Parameter
Um Software in handhabbare Teile zu zerlegen, sind Methoden (oder Funktionen) ein zentrales Konzept, und das Übergeben von Parametern ist essenziell, um sie wiederverwendbar zu machen. Dieses Beispielprojekt zeigt Ihnen, wie das geht. Außerdem schreiben wir einfache Tests, um zu überprüfen, ob Ihr Code wie erwartet funktioniert. Methoden sind auch essenziell, um testbaren Code zu schreiben.

#### Behandelte Konzepte
* [Java-Methoden](https://www.w3schools.com/java/java_methods.asp) Javas zentrales Konzept, um Code in handhabbare Blöcke zu unterteilen
* [Parameter in Methoden](https://www.w3schools.com/java/java_methods_param.asp) Wie man mit Parametern in Methoden umgeht
* [Methodenüberladung](https://www.w3schools.com/java/java_methods_overloading.asp) Die Magie, dass mehrere Methoden denselben Namen haben und dennoch etwas anderes tun können
* [JUnit-Testing](https://www.geeksforgeeks.org/advance-java/introduction-of-junit/) Schreiben einfacher Tests, um zu überprüfen, ob Ihr Code wie erwartet funktioniert

#### Aufgaben
* Überprüfen Sie den Code, führen Sie ihn aus und beobachten Sie die Ausgabe
* Schauen Sie sich die vorhandenen Methoden und deren Signaturen an und verstehen Sie, wie Parameter übergeben und verwendet werden
* Extrahieren Sie die Logik, um eine Zahl aus der Benutzereingabe zu lesen, in eine separate Methode readInput(), die die gelesene Ganzzahl zurückgibt
* Machen Sie aus dieser Anwendung einen einfachen Taschenrechner, der zwei Zahlen aus (separaten) Benutzereingaben addiert und das Ergebnis ausgibt
* Schauen Sie sich den vorhandenen Test [testGetFive()](02-methods/src/test/java/de/starwit/MethodsTest.java#L14) an und verstehen Sie, wie er funktioniert. Ändern Sie dann den Rückgabewert der getesteten Funktion [getFive()](02-methods/src/main/java/de/starwit/Methods.java#L62) und führen Sie `mvn test` aus
* Schreiben Sie neue Tests für Methoden, die Sie erstellt haben (mindestens für die vorhandene add()-Methode)
* Bonus: Lassen Sie den Taschenrechner auch Subtraktion, Multiplikation und Division beherrschen
* Bonus: Lassen Sie den Taschenrechner einen einfachen Ausdruck wie "5 + 3" aus einer einzigen Benutzereingabezeile parsen (wie ein echter Taschenrechner)

### 03 - Datentypen und Variablen
Daten in Variablen zu speichern ist essenziell für jede Programmiersprache. Wir haben dies bereits mit Zahlen (also Ganzzahlen) in den vorherigen Beispielen gemacht. Es gibt jedoch viele weitere interessante Datentypen, die gespeichert werden können. Dieses Beispiel hilft Ihnen, Javas eingebaute Typen zu verstehen und wie man sie verwendet. [Hier](https://www.w3schools.com/java/java_data_types.asp) finden Sie eine Übersicht über einige primitive Typen.

#### Behandelte Konzepte
* [Javas (primitive) Datentypen](https://www.w3schools.com/java/java_data_types.asp)
* [Typumwandlungen](https://www.w3schools.com/java/java_type_casting.asp) Wie Typen konvertiert werden und welche Regeln implizit angewendet werden
* [Operatoren](https://www.w3schools.com/java/java_operators.asp)
* [Arrays](https://www.w3schools.com/java/java_arrays.asp), mit denen Sie mehrere Dinge desselben Typs speichern können
* [Gültigkeitsbereiche](https://www.w3schools.com/java/java_scope.asp) Wie Gültigkeitsbereiche definieren, wo Variablen verwendet werden können und wo nicht

__Bitte beachten Sie__: Da Java eine objektorientierte Programmiersprache ist, kann das Typsystem erweitert werden und ist tatsächlich der viel interessantere Teil der Sprache :)

#### Aufgaben
* Überprüfen Sie den Code, führen Sie ihn aus und beobachten Sie die Ausgabe
* Lesen Sie einen Satz als String (sollte mehrere Wörter enthalten) aus der Benutzereingabe und geben Sie jedes Wort in einer eigenen Zeile aus
* Schauen Sie sich die Methode arrays() an, verstehen Sie, wie Arrays definiert, gefüllt und angesprochen werden
    * Fügen Sie eine for-Schleife hinzu, die das Array in umgekehrter Reihenfolge ausgibt
    * Geben Sie ein zufälliges Array-Element aus (Tipp: Verwenden Sie Math.random(), um einen zufälligen Index zu generieren)
    * Extrahieren Sie den Array-Initialisierungsteil in eine separate Methode initializeStringArray() und machen Sie die Länge variabel
* Lesen Sie eine Anzahl von Ganzzahlen aus der Benutzereingabe (z.B. "2 3 8 2 4 1") und geben Sie folgende Werte aus: Minimum, Maximum, Summe, Durchschnitt
* Bonus: Schauen Sie sich die Regeln zur automatischen Typumwandlung an. Können Sie sich Probleme vorstellen, die auftreten könnten? Versuchen Sie, eine Demonstration zu erstellen.

### 04 - Notiz-App
Um endlich etwas Nützliches zu tun, bauen wir jetzt eine primitive Notiz-App, die all das bisher Gelernte verwendet =)

#### Aufgaben
* Das Programm soll sich wie folgt verhalten:
    * Beim Start wird der Benutzer aufgefordert, eine Zahl einzugeben, die die Kapazität des Notizbuchs bestimmt (z.B. 10 -> kann 10 String-Einträge speichern)
    * Danach kann der Benutzer die Notiz-App verwenden, indem er nacheinander Befehle eingibt (also BEFEHL -> _ENTER_ -> AUSGABE -> BEFEHL -> _ENTER_ -> AUSGABE usw.)
* Verfügbare Befehle:
    set N STRING (setzt den String an Position N auf STRING)
    get N (gibt den String an Position N aus)
    print (gibt alle Einträge zeilenweise mit Indizes aus)
* Dies wird eine etwas komplexere Anwendung, daher schreiben wir Tests, um sicherzustellen, dass sie funktioniert (schreiben Sie mindestens einen Test für einen Befehl)
* Tipp: Schauen Sie sich [String::split()](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html#split-java.lang.String-) an
* Bonus: Entfernen Sie die Abfrage nach der Kapazität, fügen Sie die Befehle "add STRING" und "delete N" hinzu und machen Sie das Notizbuch damit variabel/dynamisch groß (verwenden Sie keine Collections!). Es kann jetzt beliebig viele Einträge speichern! (bis Ihrem Computer der Speicher ausgeht)
