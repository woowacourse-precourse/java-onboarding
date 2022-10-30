package onboarding;

import java.util.HashMap;
import java.util.Map;

public class Problem4 {
    private static Map<Character, Character> upperCaseDictionary;
    private static Map<Character, Character> lowerCaseDictionary;

    public static String solution(String word) {
        makeDictionary();
        return translate(word);
    }

    public static void makeDictionary() {
        upperCaseDictionary = new HashMap<>();
        lowerCaseDictionary = new HashMap<>();
        char alphabet = 'Z';
        for (char i = 'A'; i <= 'Z'; i++) {
            upperCaseDictionary.put(i, alphabet);
            lowerCaseDictionary.put((char) (i + 32), (char) (alphabet + 32));
            alphabet--;
        }
    }

    public static String translate(String word) {
        StringBuilder newWord = new StringBuilder(word);
        for (int i = 0; i < newWord.length(); i++) {
            char alphabet = newWord.charAt(i);
            if(alphabet == ' ') {
                continue;
            }
            if(Character.isLowerCase(alphabet)) {
                newWord.setCharAt(i, lowerCaseDictionary.get(alphabet));
                continue;
            }
            if(Character.isUpperCase(alphabet)) {
                newWord.setCharAt(i, upperCaseDictionary.get(alphabet));
            }
        }
        return newWord.toString();
    }
}
