package onboarding;

import java.util.HashMap;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";

        HashMap<Character, Character> map = new HashMap<>();
        for(int i = 0; i < 27; i++){
            map.put((char) ('a' + i), (char) ('z' - i));
            map.put((char) ('A' + i), (char) ('Z' - i));
        }

        return answer;
    }
}
