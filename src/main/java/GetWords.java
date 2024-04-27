import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.charset.StandardCharsets;
import java.util.*;




public class GetWords implements GetWordsInterface{

    @Override
    public List<String> getWords() {
        List<String> words = new ArrayList<String>();
        try {
            words = Files.readAllLines(Paths.get("src/main/files/words.txt"), StandardCharsets.UTF_8);
        } catch (Exception e) {
            System.out.println("Error opening file: " + e );
        }
        return words;
    }

    @Override
    public String getSingleWord() {
        List<String> words = getWords();
        Random random = new Random();
        int index = random.nextInt(words.size());
        return words.remove(index);
    }

}


