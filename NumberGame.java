package com.logic;
import java.util.Random;
import java.util.Scanner;
public class NumberGame1{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int min = 1, max = 100, maxAttempts = 10;
        int score = 0, roundsWon = 0;
        boolean playAgain = true;
        System.out.println("Welcome to the Number Guessing Game!");
        while (playAgain) {
            int targetNumber = random.nextInt(max - min + 1) + min;
            int attempts = 0;
            boolean guessedCorrectly = false;
            System.out.println("\nA number has been chosen between " + min + " and " + max + ". Try to guess it!");
            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;
                if (userGuess == targetNumber) {
                    System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
                    guessedCorrectly = true;
                    roundsWon++;
                    score += (maxAttempts - attempts + 1) * 10; // More points for fewer attempts
                    break;
                } else if (userGuess < targetNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
                System.out.println("Attempts left: " + (maxAttempts - attempts));
            }
            if (!guessedCorrectly) {
                System.out.println("Sorry! You've used all attempts. The number was: " + targetNumber);
            }
            System.out.println("Rounds won: " + roundsWon + " | Score: " + score);
            System.out.print("\nDo you want to play again? (yes/no): ");
            String response = scanner.next().toLowerCase();
            playAgain = response.equals("yes");
        }
        System.out.println("Thanks for playing! Final Score: " + score + " | Rounds won: " + roundsWon);
        scanner.close();
    }
}
