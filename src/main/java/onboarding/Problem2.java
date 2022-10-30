package onboarding;

import java.util.regex.Pattern;

public class Problem2 {

    // aa, bb, ccc 같은 연속되는 중복 문자
    private static final Pattern CONSECUTIVE_DUPLICATE_LETTERS = Pattern.compile("(.)\\1+");
    private static final String EMPTY_STRING = "";

    public static String solution(String cryptogram) {
        return decrypt(cryptogram);
    }

    private static String decrypt(String cryptogram) {
        String result = removeConsecutiveDuplicateLetters(cryptogram);

        if (result.equals(cryptogram)) {
            return result;
        }

        return decrypt(result);
    }

    private static String removeConsecutiveDuplicateLetters(String cryptogram) {
        return CONSECUTIVE_DUPLICATE_LETTERS.matcher(cryptogram).replaceAll(EMPTY_STRING);
    }
}
