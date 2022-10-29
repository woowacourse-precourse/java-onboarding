package onboarding;

import java.util.regex.Pattern;

public class Problem2 {

    private static final int NONE_DUPLICATE = -1;
    private static final int INPUT_LEN_MIN = 1;
    private static final int INPUT_LEN_MAX = 1000;
    private static final String LOWER_ALPHABET_REGEX = "^[a-z]*$";

    public static String solution(String cryptogram) {
        validateCryptogram(cryptogram);
        while (findDuplicateStrIndex(cryptogram) != NONE_DUPLICATE) {
            int duplicateStrIndex = findDuplicateStrIndex(cryptogram);
            String newStringFront = cryptogram.substring(0, duplicateStrIndex);
            String newStringBack = cryptogram.substring(duplicateStrIndex + 2);

            cryptogram = newStringFront + newStringBack;
        }
        return cryptogram;
    }

    private static void validateCryptogram(String cryptogram) {
        if (!isValidCryptogramForm(cryptogram) || !isValidCryptogramLen(cryptogram)) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean isValidCryptogramLen(String cryptogram) {
        return cryptogram.length() >= INPUT_LEN_MIN && cryptogram.length() <= INPUT_LEN_MAX;
    }

    private static boolean isValidCryptogramForm(String cryptogram) {
        return Pattern.matches(LOWER_ALPHABET_REGEX, cryptogram);
    }

    public static int findDuplicateStrIndex(String str) {
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == str.charAt(i - 1)) {
                return i - 1;
            }
        }
        return NONE_DUPLICATE;
    }
}