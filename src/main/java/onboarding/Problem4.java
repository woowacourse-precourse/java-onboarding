package onboarding;

import java.util.HashMap;
import java.util.Map;

public class Problem4 {
    private static Map<Character, Character> map = new HashMap<>();
    public static String solution(String word) {
        String answer = "";
        return answer;
    }
    //
    private static void insertIntoMap() {
        for (int i = 0; i <= 'z' - 'a'; i++) {
            map.put((char) ('a' + i), (char) ('z' - i));
            map.put((char) ('A' + i), (char) ('Z' - i));
        }
    }
}
