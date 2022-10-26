package onboarding;

import java.util.HashMap;
import java.util.Map;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        Map<Character, Character> dict = new HashMap<Character, Character>();
        initializeDict(dict);

        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == ' ') {
                answer += ' ';
            } else {
                answer += dict.get(word.charAt(i));
            }
        }
        return answer;
    }

    /**
     * initialize map for frog's dictionary(a-z, A-Z)
     * @param dict
     */
    static void initializeDict(Map<Character, Character> dict) {
        for (char ch = 'A'; ch <= 'Z'; ch++) {
            dict.put(ch, (char) ('Z' + ('A' - ch)));
        }
        for (char ch = 'a'; ch <= 'z'; ch++) {
            dict.put(ch, (char) ('z' + ('a' - ch)));
        }
    }
}
