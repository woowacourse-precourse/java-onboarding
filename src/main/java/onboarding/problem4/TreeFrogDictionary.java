package onboarding.problem4;

import java.util.HashMap;

public class TreeFrogDictionary {

    public final HashMap<Character, Character> DICTIONARY = new HashMap<>();

    public TreeFrogDictionary() {
        int tmp = 0;
        for (char key = 'A'; key <= 'Z'; key++, tmp++) {
            DICTIONARY.put(key, (char) ('Z' - tmp));
        }
        tmp = 0;
        for (char key = 'a'; key <= 'z'; key++, tmp++) {
            DICTIONARY.put(key, (char) ('z' - tmp));
        }
    }

    public Character translateLetter(char ch) {
        return DICTIONARY.getOrDefault(ch, ch);
    }
}
