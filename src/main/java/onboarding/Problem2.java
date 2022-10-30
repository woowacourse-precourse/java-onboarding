package onboarding;

import java.util.regex.Pattern;

public class Problem2 {

    private static final int ONE = 1;
    private static final int INPUT_LEN_MIN = 1;
    private static final int INPUT_LEN_MAX = 1000;
    private static final String LOWER_ALPHABET_REGEX = "^[a-z]*$";

    public static String solution(String cryptogram) {
        validateInput(cryptogram);
        return computeDuplicateRemovedStr(cryptogram);
    }

    private static void validateInput(String input) {
        if (!isValidCryptogramForm(input) || !isValidCryptogramLen(input)) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean isValidCryptogramLen(String input) {
        return input.length() >= INPUT_LEN_MIN && input.length() <= INPUT_LEN_MAX;
    }

    private static boolean isValidCryptogramForm(String input) {
        return Pattern.matches(LOWER_ALPHABET_REGEX, input);
    }

    private static String computeDuplicateRemovedStr(String str) {
        while (true) {
            int beforeRemoveSize = str.length();
            str = duplicateRemove(str);
            if (beforeRemoveSize == str.length() || str.length() == ONE) {
                break;
            }
        }
        return str;
    }

    static String duplicateRemove(String str) {
        StringBuilder duplicateRemovedStr = new StringBuilder();
        int i = 0;

        while (++i < str.length()) {
            if (str.charAt(i - 1) != str.charAt(i)) {
                duplicateRemovedStr.append(str.charAt(i - 1));
            }
            while (i < str.length() && str.charAt(i - 1) == str.charAt(i)) {
                i++;
            }
            if (i + 1 == str.length()) {
                duplicateRemovedStr.append(str.charAt(i));
            }
        }
        return duplicateRemovedStr.toString();
    }
}