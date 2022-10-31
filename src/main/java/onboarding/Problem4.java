package onboarding;

import java.util.HashMap;

public class Problem4 {
    public static String solution(String word) {
        HashMap<Character, Character> dictionary = new HashMap<>();
        for (char c = 'a'; c <= 'z'; c++) {
            dictionary.put(c, (char) ('a' + 'z' - c));
            dictionary.put(Character.toUpperCase(c), Character.toUpperCase((char) ('a' + 'z' - c)));
        }

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            if (dictionary.containsKey(word.charAt(i))) {
                builder.append(dictionary.get(word.charAt(i)));
            } else {
                builder.append(word.charAt(i));
            }
        }
        return builder.toString();
    }
}
