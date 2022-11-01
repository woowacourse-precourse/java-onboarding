package onboarding;

import java.util.HashMap;
import java.util.Map;

public class Problem4 {
    public static String solution(String word) {
        Frog frog = new Frog(reverseAlpha());
        return frog.speak(word);
    }

    static class Frog {
        private final Map<Character, Character> mapper;

        public Frog(Map<Character, Character> mapper) {
            this.mapper = mapper;
        }

        private String speak(String word) {
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < word.length(); i++) {
                Character key = word.charAt(i);
                if ((65 <= key && key <= 90) || (97 <= key && key <= 122)) {
                    result.append(mapper.get(key));
                } else {
                    result.append(key);
                }
            }
            return result.toString();
        }
    }
    private static Map<Character, Character> reverseAlpha() {
        Map<Character, Character> alphabets = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            alphabets.put((char) ('A' + i), (char) ('Z' - i));
            alphabets.put((char) ('a' + i), (char) ('z' - i));
        }
        return alphabets;
    }
}
