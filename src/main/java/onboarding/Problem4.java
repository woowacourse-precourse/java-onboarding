package onboarding;

import java.util.HashMap;

public class Problem4 {
    private static final HashMap<Character, Character> initial = new HashMap<>();

    public static String solution(String word) {
        initialWord();

        return replaceWord(word);
    }

    private static void initialWord() {
        for (char i = 'a'; i <= 'z'; i++) {
            char j = (char) ('z' - i + 'a');
            initial.put(i, j);
        }

        for (char i = 'A'; i <= 'Z'; i++) {
            char j = (char) ('Z' - i + 'A');
            initial.put(i, j);
        }
    }
}
