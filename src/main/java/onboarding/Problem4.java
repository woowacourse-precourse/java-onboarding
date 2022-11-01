package onboarding;

import java.util.HashMap;
import java.util.Map;

public class Problem4 {
    private static final int ASCII_UPPER_OFFSET = 155;
    private static final int ASCII_LOWER_OFFSET = 219;
    public static String solution(String word) {
        StringBuffer answer = new StringBuffer();
        char[] charArray = word.toCharArray();
        for (char c : charArray) {
            answer.append(convert(c));
        }
        return answer.toString();
    }

    private static char convert(char chr) {
        if (!isValidChar(chr)) return chr;

        if ('a' < chr) {
            return (char)(ASCII_LOWER_OFFSET - (int)chr);
        }
        return (char)(ASCII_UPPER_OFFSET - (int)chr);
    }

    private static boolean isValidChar(char chr) {
        if ('a' < chr && chr < 'z') {
            return true;
        }
        if ('A' < chr && chr < 'Z') {
            return true;
        }
        return false;
    }
}
