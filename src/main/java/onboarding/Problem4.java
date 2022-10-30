package onboarding;

import java.util.HashMap;
import java.util.Map;

public class Problem4 {
    private static final int SUM_KEY_VALUE = 155;

    public static String solution(String word) {
        String answer = "";
        return answer;
    }

    private static Map<Character, Character> createReverseDict() {
        Map<Character, Character> reverseDict = new HashMap<>();
        char base = 'A';
        while (Character.isAlphabetic(base)) {
            reverseDict.put(base, getReverseValue(base++));
        }
        return reverseDict;
    }

    private static char getReverseValue(char base) {
        return (char) (SUM_KEY_VALUE - (int) base);
    }
}