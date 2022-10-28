package onboarding.problem4;

import java.util.HashMap;
import java.util.Map;

public class DictionaryGenerator {

    public Map<Character, Character> createDictionary() {

        Map<Character, Character> characterMap = new HashMap<>();

        int asciiLast = 90;

        for (int ascii = 65; ascii <= 90; ascii++) {
            characterMap.put((char) ascii, (char) asciiLast--);
        }

        return characterMap;
    }

}
