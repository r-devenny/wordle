package wordleTests;

import org.junit.jupiter.api.Test;
import wordle.GameEngine;
import wordle.GetWords;
import wordle.UserInput;
import wordle.Word;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


class TestGameEngine {

    @Test
    void fakeGetAGuess() {
        UserInput fakeInput = new FakeUserInput("apple");
        Word guess = GameEngine.getAGuess(fakeInput);
        assertEquals("apple", guess.toString());
    }

    @Test
    void fakePlayAgain(){
        UserInput fakeInput = new FakeUserInput("y");
        boolean state = GameEngine.playAgain(fakeInput);
        assertTrue(state);

        UserInput fakeFalse = new FakeUserInput("N");
        boolean state2 = GameEngine.playAgain(fakeFalse);
        assertFalse(state2);

    }

    @Test
    void testPlayGameWin() {

        GetWords getWords = mock(GetWords.class);
        when(getWords.getSingleWord()).thenReturn("apple");

        UserInput userInput = mock(UserInput.class);
        when(userInput.getNextLine()).thenReturn("apple");

        boolean result = GameEngine.playGame(getWords, userInput);

        assertTrue(result);
    }

    @Test
    void testPlayGameLose() {

        GetWords getWords = mock(GetWords.class);
        when(getWords.getSingleWord()).thenReturn("apple");

        UserInput userInput = mock(UserInput.class);
        when(userInput.getNextLine()).thenReturn("peach");

        boolean result = GameEngine.playGame(getWords, userInput);

        assertFalse(result);

    }
}
