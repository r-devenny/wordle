import java.util.ArrayList;
import java.util.List;

public class StubGetWords implements GetWordsInterface {
    @Override
    public List<String> getWords() {
        List<String> words = new ArrayList<>();
        words.add("apple");
        words.add("peach");
        words.add("beach");
        words.add("tests");
        return words;
    }

    @Override
    public String getSingleWord() {
        return "apple";
    }
}

