package onboarding;

import java.util.HashMap;

public class Problem4 {

    private static final HashMap<Character, Character> alphabetMap;

    static {
        alphabetMap = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            alphabetMap.put((char) ('a' + i), (char) ('z' - i));
            alphabetMap.put((char) ('A' + i), (char) ('Z' - i));
        }
    }

    public static String solution(String word) {
        return word.chars()
            .mapToObj(i -> (char)i).map(c-> alphabetMap.getOrDefault(c,c).toString())
            .reduce("", String::concat);
    }
}
