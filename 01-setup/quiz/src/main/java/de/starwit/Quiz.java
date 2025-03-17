package de.starwit;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Quiz {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] questions = {
            "Aus welchen Teilen besteht die Java-Plattform?",
            "Was ist der Unterschied zwischen einem Interpreter und Compiler? Wo wird in Java was genutzt?",
            "Aus welchen Dateien besteht ein Java-Projekt?",
            "Auf welchen Prinzipien basiert Java?",
            "Warum lässt sich mit Java geschriebener Code einfacher auf andere Systeme (Mikroprozessoren/Betriebssysteme) übertragen?",
            "Wann und warum sollte man git benutzen?",
            "Was ist der Unterschied zwischen Debuggen und Ausführen?"
        };
        
        StringBuilder output = new StringBuilder();
        
        System.out.println("Willkommen zum Java-Quiz! Bitte beantworten Sie die folgenden Fragen:");
        output.append("# Willkommen zum Java-Quiz!\n\n");
    
        for (int i = 0; i < questions.length; i++) {
            System.out.println("\nFrage " + (i + 1) + ": " + questions[i]);
            output.append("### ").append(i + 1).append(". ").append(questions[i]).append("\n\n");
            System.out.print("Ihre Antwort: ");
            String answer = scanner.nextLine(); // Benutzerantwort einlesen
            output.append(answer).append("\n\n");
            
        }
        
        output.append("Quiz beendet!").append("\n");

        
        try (FileWriter writer = new FileWriter("quiz_output.md")) {
            writer.write(output.toString());
        } catch (IOException e) {
            System.out.println("Fehler beim Speichern der Datei: " + e.getMessage());
        }
        
        scanner.close();
    }
}
