package onboarding;

import java.util.HashMap;

public class Problem4 {
    private static HashMap<Character, Character> map = new HashMap<>();
    public static String solution(String word) {
        String answer = "";
        return answer;
    }

    private static void makeDictionary() {
        int diff = 25;
        for (int i = 'A'; i <= 'Z'; i++) {
            map.put((char) i, (char) (i + diff));
            diff -= 2;
        }
    }
}
