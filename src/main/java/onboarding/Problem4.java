package onboarding;

import java.util.HashMap;

public class Problem4 {

    private final static int THE_NUMBER_OF_ALPHABET = 26;

    private final static HashMap<Character, Character> treeFrogDict = new HashMap<>();


    public static String solution(String word) {
        String answer = "";
        createTreeFrogDictionary();
        return answer;
    }

    private static void createTreeFrogDictionary() {
        for (int i = 0; i < THE_NUMBER_OF_ALPHABET; i++) {
            treeFrogDict.put((char) ('a' + i), (char) ('z' - i));
            treeFrogDict.put((char) ('A' + i), (char) ('Z' - i));
        }
    }
}
