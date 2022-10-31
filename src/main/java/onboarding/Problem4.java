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
            String result = "";
            for (int i = 0; i < word.length(); i++) {
                Character key = word.charAt(i);
                if (key.equals(' ')) {
                    result += ' ';
                } else {
                    result += mapper.get(key);
                }
            }
            return result;
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
