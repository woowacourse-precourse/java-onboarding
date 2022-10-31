package onboarding;

import java.util.HashMap;
import java.util.Map;

public class Problem4 {

    private static Map<Character, Character> converterMap = new HashMap<>() {
        {
            // a -> z, z -> a
            for (char c = 'a'; c <= 'z'; c++) {
                put(c, (char) ('z' + 'a' - c));
            }
            for (char c = 'A'; c <= 'Z'; c++) {
                put(c, (char) ('Z' + 'A' - c));
            }
        }
    };

    /**
     * @param plain : 평문
     * @return char : 암호문
     */
    public static char convert(char plain) {
        return converterMap.get(plain);
    }

    public static String solution(String word) {
        String answer = "";
        for (int i = 0; i < word.length(); i++) {
            char plain = word.charAt(i);
            if (Character.isAlphabetic(plain)) {
                answer += convert(plain);
            } else {
                answer += plain;
            }
        }
        return answer;
    }
}
