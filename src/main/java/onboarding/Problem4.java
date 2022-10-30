package onboarding;

import java.util.HashMap;
import java.util.Map;

public class Problem4 {
    private static Map<Character, Character> momToChild = new HashMap<>();
    public static String solution(String word) {
        String answer = "";
        initDictionary();
        answer = getOppositeWord(word);
        return answer;
    }

    public static void initDictionary() {
        String momWord      = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        String childWord    = "ZYXWVUTSRQPONMLKJIHGFEDCBAzyxwvutsrqponmlkjihgfedcba";
        int len = momWord.length();
        for (int i = 0; i < len; ++i) {
            momToChild.put(momWord.charAt(i), childWord.charAt(i));
        }
    }

    public static String getOppositeWord(String word) {
        StringBuilder opposite = new StringBuilder(word.length());
        int len = word.length();

        for (int i = 0; i < len; ++i) {
            opposite.append(getOppositeChar(word.charAt(i)));
        }
        return opposite.toString();
    }

    public static char getOppositeChar(char ch) {
        if (Character.isAlphabetic(ch)) {
            return momToChild.get(ch);
        }
        return ch;
    }
}
