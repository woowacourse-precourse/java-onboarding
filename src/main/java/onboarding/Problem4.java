package onboarding;

import java.util.HashMap;
import java.util.stream.Collectors;

public class Problem4 {

    private final static int THE_NUMBER_OF_ALPHABET = 26;

    private final static HashMap<Character, Character> treeFrogDict = new HashMap<>();

    public static String solution(String word) {
        createTreeFrogDictionary();
        return convertWord(word);
    }

    private static String convertWord(String word) {
        return word.chars()
                .mapToObj(c -> applyFrogDictionary((char) c))
                .collect(Collectors.joining());
    }

    private static String applyFrogDictionary(char wordUnit) {
        if (isAlphabet(wordUnit)) {
            return String.valueOf(treeFrogDict.get(wordUnit));
        }
        return String.valueOf(wordUnit);
    }

    private static boolean isAlphabet(char c) {
        if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
            return true;
        }
        return false;
    }

    private static void createTreeFrogDictionary() {
        for (int i = 0; i < THE_NUMBER_OF_ALPHABET; i++) {
            treeFrogDict.put((char) ('a' + i), (char) ('z' - i));
            treeFrogDict.put((char) ('A' + i), (char) ('Z' - i));
        }
    }
}
