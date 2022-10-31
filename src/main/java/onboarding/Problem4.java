package onboarding;

import java.util.HashMap;
import java.util.Map;

public class Problem4 {

    private static Map<Character, Character> frogDict;

    public static String solution(String word) {
        initFrogDict();
        String answer = "";
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
}
