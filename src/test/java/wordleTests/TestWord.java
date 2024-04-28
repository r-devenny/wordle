package wordleTests;

import org.junit.Test;
import wordle.Word;

import java.util.HashMap;
import static org.junit.Assert.*;

public class TestWord {

    @Test
    public void testConstructor() {
        Word word = new Word("hello");
        HashMap<Integer, Character[]> expectedLetters = new HashMap<>();
        expectedLetters.put(1, new Character[]{'h', 'd'});
        expectedLetters.put(2, new Character[]{'e', 'd'});
        expectedLetters.put(3, new Character[]{'l', 'd'});
        expectedLetters.put(4, new Character[]{'l', 'd'});
        expectedLetters.put(5, new Character[]{'o', 'd'});

        assertEquals(expectedLetters.size(), word.getLetters().size());

        for (Integer key : expectedLetters.keySet()) {
            assertTrue(word.getLetters().containsKey(key));
            assertArrayEquals(expectedLetters.get(key), word.getLetters().get(key));
        }
    }

    @Test
    public void testGetLetters() {
        Word word = new Word("hello");
        assertNotNull(word.getLetters());
        assertEquals(5, word.getLetters().size());
    }

    @Test
    public void testSetLetters() {
        Word word = new Word("hello");
        HashMap<Integer, Character[]> newLetters = new HashMap<>();
        newLetters.put(1, new Character[]{'a', 'd'});
        word.setLetters(newLetters);
        assertEquals(newLetters, word.getLetters());
    }

    @Test
    public void testContainsLetterTrue() {
        Word word = new Word("hello");
        assertTrue(word.containsLetter('h'));
    }

    @Test
    public void testContainsLetterFalse() {
        Word word = new Word("hello");
        assertFalse(word.containsLetter('x'));
    }

    @Test
    public void testToString() {
        Word word = new Word("hello");
        assertEquals("hello", word.toString());
    }
}

