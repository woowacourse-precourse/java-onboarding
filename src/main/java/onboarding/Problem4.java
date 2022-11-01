package onboarding;

import java.util.HashMap;
import java.util.Map;

public class Problem4 {

    private static final int ALPHABET_SIZE = 26;

    public static String solution(String word) {
        Map<Character, Character> reverseDictionary = new HashMap<>();

        makeDictionary(reverseDictionary);

        return findInDictionary(word, reverseDictionary).toString();
    }

    public static StringBuilder findInDictionary(String word, Map<Character, Character> reverseDictionary) {
        StringBuilder result = new StringBuilder();
        for (char c : word.toCharArray()) {
            result.append(reverseDictionary.get(c));
        }
        return result;
    }

    private static void makeDictionary(Map<Character, Character> reverseDictionary) {
        putWordSpacing(reverseDictionary);
        int temp = 1;

        for (char i = 'A'; i <= 'z'; i++) {
            if (isNonAlphabet(i)) {
                temp = 1;
                continue;
            }
            reverseDictionary.put(i, (char) (i + (ALPHABET_SIZE - temp)));
            temp += 2;
        }
    }

    private static boolean isNonAlphabet(char i) {
        return 'Z' < i && i < 'a';
    }

    private static void putWordSpacing(Map<Character, Character> reverseDictionary) {
        reverseDictionary.put(' ', ' ');
    }
}
