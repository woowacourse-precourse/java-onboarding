package onboarding;

import java.util.HashMap;

public class Problem4 {
    private static final HashMap<Character, Character> initial = new HashMap<>();

    public static String solution(String word) {
        initialWord();

        return replaceWord(word);
    }
}
