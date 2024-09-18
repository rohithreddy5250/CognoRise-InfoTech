import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class HangmanGame {
    
    // Array of possible words
    private static final String[] WORDS = {"java", "python", "javascript", "hangman", "developer"};
    // Hangman stages for wrong guesses
    private static final String[] HANGMAN_STAGES = {
        """
          -----
          |   |
              |
              |
              |
              |
        =========
        """,
        """
          -----
          |   |
          O   |
              |
              |
              |
        =========
        """,
        """
          -----
          |   |
          O   |
          |   |
              |
              |
        =========
        """,
        """
          -----
          |   |
          O   |
         /|   |
              |
              |
        =========
        """,
        """
          -----
          |   |
          O   |
         /|\\  |
              |
              |
        =========
        """,
        """
          -----
          |   |
          O   |
         /|\\  |
         /    |
              |
        =========
        """,
        """
          -----
          |   |
          O   |
         /|\\  |
         / \\  |
              |
        =========
        """
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        // Select a random word from the array
        String chosenWord = WORDS[random.nextInt(WORDS.length)];
        int wordLength = chosenWord.length();
        
        // Track guessed letters and incorrect guesses
        ArrayList<Character> guessedLetters = new ArrayList<>();
        int incorrectGuesses = 0;
        boolean wordGuessed = false;

        // Array to display the guessed word status
        char[] displayWord = new char[wordLength];
        for (int i = 0; i < wordLength; i++) {
            displayWord[i] = '_';
        }

        // Main game loop
        while (incorrectGuesses < HANGMAN_STAGES.length - 1) {
            System.out.println(HANGMAN_STAGES[incorrectGuesses]);
            System.out.println("Word: " + new String(displayWord));
            System.out.print("Guessed letters: " + guessedLetters + "\n");
            System.out.print("Enter a letter: ");
            
            // Get user input
            char guess = scanner.next().toLowerCase().charAt(0);
            
            // Check if the letter has been guessed already
            if (guessedLetters.contains(guess)) {
                System.out.println("You already guessed that letter.");
                continue;
            }

            // Add the guessed letter to the list of guessed letters
            guessedLetters.add(guess);
            
            // Check if the guessed letter is in the chosen word
            boolean correctGuess = false;
            for (int i = 0; i < wordLength; i++) {
                if (chosenWord.charAt(i) == guess) {
                    displayWord[i] = guess;
                    correctGuess = true;
                }
            }

            // Update for incorrect guess
            if (!correctGuess) {
                incorrectGuesses++;
            }

            // Check if the word is fully guessed
            wordGuessed = new String(displayWord).equals(chosenWord);
            if (wordGuessed) {
                break;
            }
        }

        // Display final result
        if (wordGuessed) {
            System.out.println("Congratulations! You guessed the word: " + chosenWord);
        } else {
            System.out.println(HANGMAN_STAGES[HANGMAN_STAGES.length - 1]);
            System.out.println("Game Over! The word was: " + chosenWord);
        }
        
        scanner.close();
    }
}
