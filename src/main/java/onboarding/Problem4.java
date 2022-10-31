package onboarding;

import java.util.HashMap;
import java.util.Map;

public class Problem4 {
    static class FrogCode {
        Map<Character, Character> codeMap = new HashMap<>();

        public FrogCode() {
            for(int i = 0; i < 26; i++) {
                this.codeMap.put((char) ('A' + i), (char) ('Z' - i));
                this.codeMap.put((char) ('a' + i), (char) ('z' - i));
            }
            this.codeMap.put(' ', ' ');
        }
    }
    public static String solution(String word) {
        String answer = "";
        return answer;
    }
}
