package onboarding;

import java.util.HashMap;
import java.util.Map;

public class Problem4 {
    public static Map<Character, Character> initDictionary() {
        Map<Character, Character> dictionary = new HashMap<>();

        char upperCase = 'A';
        char lowerCase = 'a';

        for (int i = 0; i < 26; i++) {
            dictionary.put((char) (upperCase + i), (char) (upperCase + 25 - i));
            dictionary.put((char) (lowerCase + i), (char) (lowerCase + 25 - i));
        }

        return dictionary;
    }

    public static String convertWord(String word, Map<Character, Character> dictionary){
        StringBuilder text = new StringBuilder(word);

        for (int i = 0; i < text.length(); i++) {
            char nextChar = text.charAt(i);
            text.setCharAt(i, dictionary.getOrDefault(nextChar, nextChar));
        }

        return text.toString();
    }

    public static String solution(String word) {
        Map<Character, Character> dictionary = initDictionary();

        return convertWord(word, dictionary);
    }
}
