package de.starwit;

import java.util.Random;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        int secretNumber = random.nextInt(100) + 1; // Random number between 1 and 100
        int userGuess = 0; //guessed number
        int attempts = 0;
        boolean guessedCorrectly = false;
        
        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I have picked a number between 1 and 100. Try to guess it!");
        
        while (!guessedCorrectly) {
            System.out.print("Enter your guess: ");
            userGuess = scanner.nextInt();

            //TODO: Increment number of attempts

            //TODO: Create If-statemant
            //if number is too low, print: Too low! Try again."
            //if number is too high, print: "Too high! Try again."
            //if number is guessed correctly, stop while loop and output number of attempts
        }
        
        scanner.close();
    }
}
