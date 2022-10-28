package onboarding;

import java.util.HashMap;
import java.util.Map;

public class Problem4 {
    public static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    public static final int MINIMUM_STRING_LENGTH = 1;
    public static final int MAXIMUM_STRING_LENGTH = 1000;

    public static String solution(String word) {
        validateRange(word);
        Map<Character, Character> dictionary = generateDictionary();
    }

    public static void validateRange(String word) {
        if (word.length() < MINIMUM_STRING_LENGTH || MAXIMUM_STRING_LENGTH < word.length()) {
            throw new IllegalArgumentException();
        }
    }

    private static Map<Character, Character> generateDictionary() {
        Map<Character, Character> dictionary = new HashMap<>();
        int maxIndex = ALPHABET.length() - 1;
        String alphabetUpperCase = ALPHABET.toUpperCase();

        for (int i = 0; i < ALPHABET.length(); i++) {
            dictionary.put(ALPHABET.charAt(i), ALPHABET.charAt(maxIndex - i));
            dictionary.put(alphabetUpperCase.charAt(i), alphabetUpperCase.charAt(maxIndex - i));
        }

        return dictionary;
    }
}
