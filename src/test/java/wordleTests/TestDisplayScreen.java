package wordleTests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import wordle.DisplayScreen;
import wordle.Word;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class TestDisplayScreen {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void testDisplayGameBoard() {
        DisplayScreen displayScreen = new DisplayScreen();
        Word word = new Word("apple");
        word.getLetters().put(1, new Character[]{'a', 'c'});
        word.getLetters().put(2, new Character[]{'p', 'p'});
        word.getLetters().put(3, new Character[]{'p', 'p'});
        word.getLetters().put(4, new Character[]{'l', 'd'});
        word.getLetters().put(5, new Character[]{'e', 'd'});

        displayScreen.displayGameBoard(word);

        assertNotNull(outContent.toString().trim());
    }
}

