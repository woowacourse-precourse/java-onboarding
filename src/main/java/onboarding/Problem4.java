package onboarding;

import java.util.HashMap;
import java.util.Map;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        return answer;
    }

    private static Map<Character, Character> reverseAlpha() {
        Map<Character, Character> alphabets = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            alphabets.put((char) ('A' + i), (char) ('Z' - i));
            alphabets.put((char) ('a' + i), (char) ('z' - i));
        }
        return alphabets;
    }
}
