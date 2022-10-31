package onboarding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem4 {
    public static String UPPER_ALPHA = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static String LOWER_ALPHA = "abcdefghijknlmopqrstuvwxyz";
    public static final String TOKEN = UPPER_ALPHA + LOWER_ALPHA + " ";
    public static String solution(String word) {
        Map<Character, Character> alphaMap = new HashMap<>();
        List<Character> originSrc = new ArrayList<>();


        backwardMap(alphaMap);
        String answer = "";

        return answer;
    }

    public static String reverseAlpha() {
        String result = "";


        return result;
    }
    public static void backwardMap(Map<Character, Character> alphaMap) {
        for (int i = 0; i < 26; i++) {
            alphaMap.put((char) ('A' + i), (char) ('Z' - 1));
            alphaMap.put((char) ('a' + i), (char) ('z' - 1));
        }
    }
}
