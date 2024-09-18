import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        // Generate a random number between 1 and 100
        int randomNumber = random.nextInt(100) + 1;
        
        int attempts = 0;
        int maxAttempts = 5;  // Maximum number of attempts
        boolean hasWon = false;

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I have picked a number between 1 and 100. Can you guess it?");
        
        // Game loop
        while (attempts < maxAttempts) {
            System.out.print("Enter your guess: ");
            int userGuess = scanner.nextInt();
            attempts++;
            
            // Compare user's guess with the generated number
            if (userGuess > randomNumber) {
                System.out.println("Your guess is too high.");
            } else if (userGuess < randomNumber) {
                System.out.println("Your guess is too low.");
            } else {
                hasWon = true;
                break;  // The guess is correct, exit the loop
            }

            // Provide feedback on the remaining attempts
            System.out.println("You have " + (maxAttempts - attempts) + " attempts left.");
        }

        // Check the game result
        if (hasWon) {
            System.out.println("Congratulations! You guessed the number " + randomNumber + " in " + attempts + " attempts.");
        } else {
            System.out.println("Game over! You've used all " + maxAttempts + " attempts. The correct number was " + randomNumber + ".");
        }
        
        scanner.close();
    }
}
