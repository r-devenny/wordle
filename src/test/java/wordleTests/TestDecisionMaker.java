package wordleTests;

import org.junit.Test;
import wordle.DecisionMaker;
import wordle.Word;

import java.util.HashMap;
import static org.junit.Assert.*;

public class TestDecisionMaker {

    @Test
    public void testCompareGuess_CorrectLettersAndPositions() {
        DecisionMaker decisionMaker = new DecisionMaker();
        Word userGuess = new Word("apple");
        Word target = new Word("apple");

        Word result = decisionMaker.compareGuess(userGuess, target);

        // All letters should be marked as correct (state 'c')
        HashMap<Integer, Character[]> expectedLetters = new HashMap<>();
        expectedLetters.put(1, new Character[]{'a', 'c'});
        expectedLetters.put(2, new Character[]{'p', 'c'});
        expectedLetters.put(3, new Character[]{'p', 'c'});
        expectedLetters.put(4, new Character[]{'l', 'c'});
        expectedLetters.put(5, new Character[]{'e', 'c'});

        for (Integer key : expectedLetters.keySet()) {
            assertTrue(result.getLetters().containsKey(key));
            assertArrayEquals(expectedLetters.get(key), result.getLetters().get(key));
        }
    }

    @Test
    public void testCompareGuess_CorrectLettersWrongPositions() {
        DecisionMaker decisionMaker = new DecisionMaker();
        Word userGuess = new Word("stone");
        Word target = new Word("notes");

        Word result = decisionMaker.compareGuess(userGuess, target);

        // Only 'a' should be marked as correct (state 'c'), other letters should be marked as present (state 'p')
        HashMap<Integer, Character[]> expectedLetters = new HashMap<>();
        expectedLetters.put(1, new Character[]{'s', 'p'});
        expectedLetters.put(2, new Character[]{'t', 'p'});
        expectedLetters.put(3, new Character[]{'o', 'p'});
        expectedLetters.put(4, new Character[]{'n', 'p'});
        expectedLetters.put(5, new Character[]{'e', 'p'});

        for (Integer key : expectedLetters.keySet()) {
            assertTrue(result.getLetters().containsKey(key));
            assertArrayEquals(expectedLetters.get(key), result.getLetters().get(key));
        }
    }

    @Test
    public void testCompareGuess_IncorrectLetters() {
        DecisionMaker decisionMaker = new DecisionMaker();
        Word userGuess = new Word("charm");
        Word target = new Word("lists");

        Word result = decisionMaker.compareGuess(userGuess, target);


        HashMap<Integer, Character[]> expectedLetters = new HashMap<>();
        expectedLetters.put(1, new Character[]{'c', 'd'});
        expectedLetters.put(2, new Character[]{'h', 'd'});
        expectedLetters.put(3, new Character[]{'a', 'd'});
        expectedLetters.put(4, new Character[]{'r', 'd'});
        expectedLetters.put(5, new Character[]{'m', 'd'});
        for (Integer key : expectedLetters.keySet()) {
            assertTrue(result.getLetters().containsKey(key));
            assertArrayEquals(expectedLetters.get(key), result.getLetters().get(key));
        }
    }
}


