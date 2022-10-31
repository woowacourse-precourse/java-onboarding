package onboarding.problem4;

import java.util.HashMap;
import java.util.Map;

public class DictionaryGenerator {

    public Map<Character, Character> createDictionary() {

        Map<Character, Character> characterMap = new HashMap<>();

        char asciiLast = 'Z';

        for (char ascii = 'A'; ascii <= 'Z'; ascii++) {
            characterMap.put(ascii, asciiLast--);
        }

        return characterMap;
    }

}
