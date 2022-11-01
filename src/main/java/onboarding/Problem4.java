package onboarding;

import java.util.HashMap;

public class Problem4 {

    public static String solution(String word) {
        HashMap<Character, Character> greenFrogDictionary = createGreenFrogDictionary();
        return answer;
    }

    private static HashMap<Character, Character> createGreenFrogDictionary() {
        HashMap<Character, Character> greenFrogDictionary = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            greenFrogDictionary.put((char) ('a' + i), (char) ('z' - i));
            greenFrogDictionary.put((char) ('A' + i), (char) ('Z' - i));
        }
        return greenFrogDictionary;
    }
}
