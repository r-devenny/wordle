import java.util.HashMap;

public class Word {

    private HashMap<Integer, Character[]> letters; // HashMap with key as position and value as an array containing the letter and its state

    public Word(String fullWord) {
        this.letters = new HashMap<>();
        for (int i = 0; i < fullWord.length(); i++) {
            char letter = fullWord.charAt(i);
            // Initialize the array with the letter and its initial state
            Character[] letterState = {letter, 'd'};
            this.letters.put(i + 1, letterState); // Use i + 1 as the key to start from 1
        }
    }

    public HashMap<Integer, Character[]> getLetters() {
        return letters;
    }

    public void setLetters(HashMap<Integer, Character[]> letters) {
        this.letters = letters;
    }

    public boolean containsLetter(char letter) {
        for (Character[] letterState : letters.values()) {
            if (letterState[0] == letter) {
                return true;
            }
        }
        return false;
    }

}
