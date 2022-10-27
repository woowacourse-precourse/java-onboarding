package onboarding;

import java.util.HashMap;
import java.util.Map;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        return answer;
    }

    public static Map<String, String> makeDict() {
        HashMap<String, String> dict = new HashMap<>();

        for (int i = 0; i < 26; i++) {
            dict.put(String.valueOf((char) (65 + i)), String.valueOf((char) (90 - i)));
            dict.put(String.valueOf((char) (97 + i)), String.valueOf((char) (122 - i)));
        }

        return dict;
    }
}
