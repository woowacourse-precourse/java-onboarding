package onboarding;

import java.util.HashMap;
import java.util.Map;

public class Problem4 {
    public static final char upperCase = 'A';
    public static final char lowerCase = 'a';
    public static Map<Character, Character> dictionary;

    public static void initDictionary() {
        dictionary = new HashMap<>();

        for (int i = 0; i < 26; i++) {
            dictionary.put((char) (upperCase + i), (char) (upperCase + 25 - i));
            dictionary.put((char) (lowerCase + i), (char) (lowerCase + 25 - i));
        }
    }

    public static String convertWord(String word) {
        StringBuilder text = new StringBuilder(word);

        for (int i = 0; i < text.length(); i++) {
            char originalChar = text.charAt(i);
            text.setCharAt(i, dictionary.getOrDefault(originalChar, originalChar));
        }

        return text.toString();
    }

    public static String solution(String word) {
        initDictionary();
        return convertWord(word);
    }
}
