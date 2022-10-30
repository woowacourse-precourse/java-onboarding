package onboarding;

import java.util.HashMap;
import java.util.Map;

public class Problem4 {
    private static Map<Character, Character> upperCaseDictionary;
    private static Map<Character, Character> lowerCaseDictionary;

    public static String solution(String word) {
        makeDictionary();
        String answer = translate(word);
        return answer;
    }

    public static void makeDictionary() {
        upperCaseDictionary = new HashMap<>();
        lowerCaseDictionary = new HashMap<>();
        char alphabet = 'Z';
        for (char i = 'A'; i <= 'Z'; i++) {
            upperCaseDictionary.put(i, alphabet);
            lowerCaseDictionary.put((char) (i - 32), (char) (alphabet - 32));
        }
    }

    public static String translate(String word) {

        return "";
    }
}
