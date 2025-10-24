package de.starwit;

import java.util.Random;
import java.util.Scanner;

public class Quiz {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        String[][] questions = {
            {"Welche der folgenden ist eine primitive Datentyp in Java?", "String", "int", "Array", "2"},
            {"Welche Schleife wird verwendet, wenn die Anzahl der Iterationen bekannt ist?", "while", "for", "do-while", "2"},
            {"Welches Schlüsselwort wird verwendet, um eine Methode in Java zu definieren?", "method", "function", "void", "3"},
            {"Was bedeutet '==' in Java?", "Zuweisung", "Vergleich", "Logische UND-Verknüpfung", "2"},
            {"Welches Schlüsselwort beendet eine Schleife sofort?", "exit", "break", "return", "2"},
            {"Was ist ein Konstruktor in Java?", "Eine spezielle Methode zur Initialisierung eines Objekts", "Ein Datentyp", "Ein Schlüsselwort", "1"}
        };
        
        int score = 0;
        
        System.out.println("Willkommen zum Java-Quiz! Wählen Sie die richtige Antwort aus.");
        
        for (int i = 0; i < questions.length; i++) {
            System.out.println("\nFrage " + (i + 1) + ": " + questions[i][0]);
            System.out.println("1) " + questions[i][1]);
            System.out.println("2) " + questions[i][2]);
            System.out.println("3) " + questions[i][3]);
            
            System.out.print("Ihre Antwort (1-3): ");
            int answer = scanner.nextInt();
            
            if (answer == Integer.parseInt(questions[i][4])) {
                System.out.println("Richtig!");
                score++;
            } else {
                System.out.println("Falsch! Die richtige Antwort war: " + questions[i][Integer.parseInt(questions[i][4])]);
            }
        }
        
        System.out.println("\nQuiz beendet! Ihr Score: " + score + "/" + questions.length);
        scanner.close();
    }
}
