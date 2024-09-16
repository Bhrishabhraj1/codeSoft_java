import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain = true;
        int roundsWon = 0;
        int totalRounds = 0;

        System.out.println("Welcome to the Number Guessing Game!");

        while (playAgain) {
            int numberToGuess = random.nextInt(100) + 1; 
            int maxAttempts = 5; 
            int attempts = 0;
            boolean guessedCorrectly = false;

            System.out.println("\nA new round has started! Guess a number between 1 and 100.");
            System.out.println("You have " + maxAttempts + " attempts to guess the number.");

            while (attempts < maxAttempts && !guessedCorrectly) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == numberToGuess) {
                    System.out.println("Congratulations! You guessed the number correctly.");
                    guessedCorrectly = true;
                    roundsWon++;
                } else if (userGuess < numberToGuess) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }

                System.out.println("Attempts left: " + (maxAttempts - attempts));
            }

            if (!guessedCorrectly) {
                System.out.println("Sorry, you've run out of attempts. The correct number was " + numberToGuess + ".");
            }

            totalRounds++;

           
            System.out.print("Do you want to play another round? (yes/no): ");
            String userResponse = scanner.next().toLowerCase();

            if (!userResponse.equals("yes")) {
                playAgain = false;
                System.out.println("\nGame over!");
                System.out.println("Total rounds played: " + totalRounds);
                System.out.println("Rounds won: " + roundsWon);
            }
        }

        scanner.close();
    }
}
