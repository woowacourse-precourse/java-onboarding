package onboarding;

import java.util.HashMap;
import java.util.Map;

public class Problem4 {
    static Map<Character, Character> frogDict;

    static {
        frogDict = new HashMap<>();

        char from = 'a';
        char to = 'z';
        for (int i = 0; i < 26; i++, from++, to--) {
            frogDict.put(from, to);
            frogDict.put(Character.toUpperCase(from), Character.toUpperCase(to));
        }
    }

    public static String solution(String word) {
        StringBuilder result = new StringBuilder();
        char c;

        for (int i = 0; i < word.length(); i++) {
            c = word.charAt(i);
            if (frogDict.containsKey(c)) {
                result.append(frogDict.get(c));
            } else {
                result.append(c);
            }

        }

        return result.toString();
    }
}
