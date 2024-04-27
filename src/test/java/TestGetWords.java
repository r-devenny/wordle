import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TestGetWords {

    @Test
    void testGetSingleWord() {
        StubGetWords stub = new StubGetWords();

        String word = stub.getSingleWord();
        assertEquals("apple", word);
    }

    @Test
    void testGetWords() {
        StubGetWords stub = new StubGetWords();

        List<String> words = stub.getWords();

        assertEquals(4, words.size());
        assertEquals("apple", words.get(0));
        assertEquals("peach", words.get(1));
        assertEquals("beach", words.get(2));
        assertEquals("tests", words.get(3));
    }

    @Test
    void testGetWordsWithMocks() {
        GetWordsInterface getWords = mock(GetWordsInterface.class);
        when(getWords.getWords()).thenReturn(new ArrayList<>(Arrays.asList("apple", "peach", "beach", "tests")));


        GetWords getWordsObj = new GetWords();

        List<String> words = getWordsObj.getWords();

        assertEquals(10, words.size());
        assertEquals("apple", words.get(0));
        assertEquals("peach", words.get(1));
        assertEquals("beach", words.get(2));
    }
}

