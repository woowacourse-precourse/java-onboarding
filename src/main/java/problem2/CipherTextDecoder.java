package problem2;

import java.util.ArrayList;
import java.util.List;

public class CipherTextDecoder {
    public List<Character> parseToAlphabetList(String word) {
        List<Character> characters = new ArrayList<>();

        for (int i = 0; i < word.length(); i++) {
            characters.add(word.charAt(i));
        }
        return characters;
    }
}
