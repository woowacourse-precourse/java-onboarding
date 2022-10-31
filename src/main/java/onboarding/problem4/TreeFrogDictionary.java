package onboarding.problem4;

import java.util.HashMap;

public class TreeFrogDictionary {

    public final HashMap<Character, Character> DICTIONARY = new HashMap<>();

    public TreeFrogDictionary() {
        int tmp = 0;
        for (char upperAlpha = 'A'; upperAlpha <= 'Z'; upperAlpha++, tmp++) {
            DICTIONARY.put(upperAlpha, (char) ('Z' - tmp));
        }
        tmp = 0;
        for (char lowerAlpha = 'a'; lowerAlpha <= 'z'; lowerAlpha++, tmp++) {
            DICTIONARY.put(lowerAlpha, (char) ('z' - tmp));
        }
    }

    public String translate(String originalStr) {
        String translatedStr = "";
        for (char originalCh : originalStr.toCharArray()) {
            translatedStr += translateLetter(originalCh);
        }
        return translatedStr;
    }

    public Character translateLetter(char ch) {
        return DICTIONARY.getOrDefault(ch, ch);
    }
}
