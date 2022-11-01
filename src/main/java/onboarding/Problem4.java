package onboarding;

import java.util.HashMap;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";

        HashMap<Character, Character> treeFrogDictionary = makeTreeFrogDictionary();

        return answer;
    }

    private static HashMap<Character, Character> makeTreeFrogDictionary() {
        int alphabetCount = 26;
        int halfOfTheAlphabetCount = alphabetCount / 2;

        HashMap<Character, Character> map = new HashMap<>();

        for (int i = 0; i < halfOfTheAlphabetCount; i++) {
            map.put((char)('A' + i), (char)('Z' - i));
            map.put((char)('Z' - i), (char)('A' + i));
        }

        return map;
    }
}
