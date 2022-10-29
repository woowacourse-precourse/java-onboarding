package onboarding;

import java.util.HashMap;
import java.util.Map;


public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        GreenFlog greenflog = new GreenFlog();
        greenflog.makeMap();

        for (int i=0; i<word.length(); i++) {
            answer += greenflog.reform(word.charAt(i));
        }
        return answer;
    }
}

class GreenFlog {
    Map<Character, Character> flog_map = new HashMap<>();
    void makeMap() {
        int len = 'z' - 'a' + 1;

        for (int i=0; i<len; i++) {
            char key = (char) ('a' + i);
            char value = (char) ('z' - i);
            flog_map.put(key, value);
        }

        for (int j=0; j<len; j++) {
            char key = (char) ('A' + j);
            char value = (char) ('Z' - j);
            flog_map.put(key, value);
        }
    }

    char reform(char ch) {
        if (Character.isAlphabetic(ch)) {
            return flog_map.get(ch);
        }
        return ch;
    }
}
