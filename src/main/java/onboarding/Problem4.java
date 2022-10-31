package onboarding;

import java.util.HashMap;
import java.util.Map;

public class Problem4 {

    private static Map<Character, Character> frogDict;

    public static String solution(String word) {
        initFrogDict();
        
        char[] words = word.toCharArray();
        String answer = "";

        for (char c : words) {
            if (isAlphabet(c)) {
                answer += convert(c);
            } else {
                answer += c;
            }
        }
        return answer;
    }

    private static void initFrogDict() {
        frogDict = new HashMap<>();
        for (char c = 'A'; c <= 'Z'; c++) {
            frogDict.put(c, (char) ('Z' - c + 'A'));
        }
        for (char c = 'a'; c <= 'z'; c++) {
            frogDict.put(c, (char) ('z' - c + 'a'));
        }
    }

    private static boolean isAlphabet(char c) {
        if (('A' <= c && c <= 'Z') || ('a' <= c && c <= 'z')) {
            return true;
        }
        return false;
    }

    private static char convert(char c) {
        return frogDict.get(c);
    }
}
