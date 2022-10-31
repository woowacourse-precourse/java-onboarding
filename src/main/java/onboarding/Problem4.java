package onboarding;

import java.util.HashMap;
import java.util.Map;

public class Problem4 {
    private static final int ALPHABET_COUNT = 26;

    public static String solution(String word) {
        Map<Character, Character> wordDictionary = createWordDictionary();

        return "tmp"; //TODO - 임시값 수정
    }

    private static Map<Character, Character> createWordDictionary() {
        Map<Character, Character> wordDictionary = new HashMap<>(ALPHABET_COUNT);

        for (int i = 0; i < ALPHABET_COUNT; i++) {
            putAlphabetPairInWordDictionary(wordDictionary, i);
        }
        return wordDictionary;
    }

    private static void putAlphabetPairInWordDictionary(Map<Character, Character> wordDictionary, int i) {
        wordDictionary.put((char)('a' + i), (char)('z' - i));
        wordDictionary.put((char)('A' + i), (char)('Z' - i));
    }
}
