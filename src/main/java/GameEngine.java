import java.util.Scanner;


public class GameEngine {


    public static void displayStartPage() {
        System.out.println("Welcome to my Wordle Game! \n \n");
        System.out.println("------------------------------------");
        System.out.println("To start playing, please type \"y\".");
    }

    public static Word getAGuess() {
        System.out.println("Enter your guess: ");
        String guessInput = "";

        while (guessInput.length() != 5) {
            Scanner input = new Scanner(System.in);
            guessInput = input.nextLine().trim().toLowerCase();

            if (guessInput.length() != 5) {
                System.out.println("Please enter a 5 letter word.");
            }
        }


        return new Word(guessInput);
    }

    public static boolean playGame(GetWords getWords) {
        String rawWord = getWords.getSingleWord();
        Word targetWord = new Word(rawWord);

        DisplayScreen display = new DisplayScreen();
        DecisionMaker decisionMaker = new DecisionMaker();

        for (int i = 0; i < 6; i++) {
            Word guess = getAGuess();
            guess = decisionMaker.compareGuess(guess, targetWord);
            display.displayGameBoard(guess);

            int corrects = 0;
            for (int position : guess.getLetters().keySet()) {
                Character[] letterState = guess.getLetters().get(position);
                char state = letterState[1];
                if (state == 'c') {
                    corrects++;
                }
            }

            if (corrects == 5) {
                System.out.println("You won! The word was: " + rawWord);
                return true;
            }
        }

        System.out.println("You lost! The word was: " + rawWord);
        return false;
    }

    public static void main(String[] args) {
        GetWords getWords = new GetWords();
        boolean state = false;

        displayStartPage();

        Scanner input = new Scanner(System.in);
        String playInput = input.nextLine();
        if (playInput.equals("y")) {
            state = true;
        }

        while (state) {
            state = playGame(getWords);
            if (state) {
                System.out.println("\nDo you want to play again? (Type \"y\" to continue or any other key to quit)");
                playInput = input.nextLine();
                state = playInput.equals("y");
            }
        }


    }
}

