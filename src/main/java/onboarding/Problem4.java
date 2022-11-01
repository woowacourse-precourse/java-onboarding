package onboarding;

public class Problem4 {
    private static final char UPPER_CASE_START = 'A';
    private static final char UPPER_CASE_END = 'Z';
    private static final char LOWER_CASE_START = 'a';
    private static final char LOWER_CASE_END = 'z';

    public static String solution(String word) {
        String answer = "";

        int length = word.length();

        for (int i = 0; i < length; i++) {
            char alpha = word.charAt(i);
            answer += reverse(alpha);
        }

        return answer;
    }

    private static String reverse(char alpha) {
        String result = charToString(alpha);

        if (alpha >= UPPER_CASE_START && alpha <= UPPER_CASE_END) {
            result = reverseUpperCase(alpha);
        } else if (alpha >= LOWER_CASE_START && alpha <= LOWER_CASE_END) {
            result = reverseLowerCase(alpha);
        }

        return result;
    }

    private static String reverseLowerCase(char alpha) {
        int difference = alpha - LOWER_CASE_START;

        char reverseAlpha = (char) (LOWER_CASE_END - difference);
        String result = charToString(reverseAlpha);

        return result;
    }

    private static String reverseUpperCase(char alpha) {
        int difference = alpha - UPPER_CASE_START;

        char reverseAlpha = (char) (UPPER_CASE_END - difference);
        String result = charToString(reverseAlpha);

        return result;
    }

    private static String charToString(char c) {
        return String.valueOf(c);
    }
}
