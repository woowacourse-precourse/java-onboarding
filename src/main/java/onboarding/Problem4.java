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

    public static String solution(String word) {
        Map<Character, Character> dictionary = initDictionary();

        StringBuilder sb = new StringBuilder(word);
        for (int i = 0; i < sb.length(); i++) {
            char next = sb.charAt(i);

            if (dictionary.containsKey(next))
                sb.setCharAt(i, dictionary.get(next));
        }

        return sb.toString();
    }
}
