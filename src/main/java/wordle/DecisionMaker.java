package wordle;

import java.util.HashMap;

public class DecisionMaker {

    public Word compareGuess(Word userGuess, Word target) {
        HashMap<Integer, Character[]> userLetters = userGuess.getLetters();
        HashMap<Integer, Character[]> targetLetters = target.getLetters();

        // Check for present letters (letters in the guess but not in the correct position)
        for (int position : userLetters.keySet()) {
            if (target.containsLetter(userLetters.get(position)[0])) {
                userLetters.get(position)[1] = 'p'; // Set state to 'p' for present
            }
        }

        for (int position : targetLetters.keySet()) {
            if (userLetters.containsKey(position)) {
                Character[] targetLetterState = targetLetters.get(position);
                Character[] userLetterState = userLetters.get(position);

                char targetLetter = targetLetterState[0];
                char userLetter = userLetterState[0];

                if (userLetter == targetLetter) {
                    userLetterState[1] = 'c'; // Set state to 'c' for correct
                }
            }
        }



        return userGuess;
    }
}

