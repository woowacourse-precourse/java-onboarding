package onboarding;

import java.util.HashMap;
import java.util.Map;

public class Problem4 {
    private final static Map<Character, Character> MOM_TO_CHILD = new HashMap<>();
    public static String solution(String word) {
        String answer = "";
        initDictionary();
        answer = getOppositeWord(word);
        return answer;
    }

    public static void initDictionary() {
        final String MOM_WORD      = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        final String CHILD_WORD    = "ZYXWVUTSRQPONMLKJIHGFEDCBAzyxwvutsrqponmlkjihgfedcba";
        int len = MOM_WORD.length();
        for (int i = 0; i < len; ++i) {
            MOM_TO_CHILD.put(MOM_WORD.charAt(i), CHILD_WORD.charAt(i));
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
            return MOM_TO_CHILD.get(ch);
        }
        return ch;
    }
}
