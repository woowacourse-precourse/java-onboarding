package onboarding;

import java.util.HashMap;
import java.util.Map;

public class Problem4 {
    public static String solution(String word) {
        StringBuilder answer = new StringBuilder();

        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < 25; i++) {
            map.put((char) ('A' + i), (char)('Z' - i));
            map.put((char) ('a' + i), (char)('z' - i));
        }

        for (int i = 0; i < word.length(); i++) {
            Character c = word.charAt(i);
            answer.append(map.getOrDefault(c, c));
        }
        return answer.toString();
    }
}
