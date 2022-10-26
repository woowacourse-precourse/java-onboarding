package onboarding;

import java.util.HashMap;
import java.util.Map;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        Map<Character, Character> alphabets = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            alphabets.put( (char)(i + 'a'), (char)('z' - i));
        }
        return answer;
    }
}