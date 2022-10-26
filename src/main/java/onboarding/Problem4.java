package onboarding;

import java.util.HashMap;
import java.util.Map;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";

        Map<Character, Character> treeFrogDictionary = getTreeFrogDictionary();


        return answer;
    }

    private static Map<Character, Character> getTreeFrogDictionary() {
        Map<Character, Character> treeFrogDictionary = new HashMap<>();
        char from = 'A';
        char to = 'Z';
        for (int i = 0; i < 26; i++) {
            treeFrogDictionary.put((char)(from + i), (char)(to - i));
        }

        from = 'a';
        to = 'z';
        for (int i = 0; i < 26; i++) {
            treeFrogDictionary.put((char)(from + i), (char)(to - i));
        }

        return treeFrogDictionary;
    }
}
