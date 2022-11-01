package onboarding;

import java.util.HashMap;
import java.util.Map;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        return answer;
    }

    private static Map<Character, Character> getConversionRules() {
        Map<Character, Character> conversionRules = new HashMap<Character, Character>();
        for (int i = 0; i < 26; i++) {
            conversionRules.put((char) (65+i), (char) (90-i));
            conversionRules.put((char) (97+i),(char) (122-i));
        }
        return conversionRules;
    }

}
