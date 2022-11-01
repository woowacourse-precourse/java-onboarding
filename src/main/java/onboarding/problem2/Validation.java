package onboarding.problem2;

import java.util.regex.Pattern;

public class Validation {
    private static final int MAX_LENGTH = 1000;
    private static final int MIN_LENGTH = 1;
    private static final String LOWERCASE_STR_REGEXP = "^[a-z]+$";
    private static final String LENGTH_EXCEPTION_MESSAGE = "문자열의 길이가 범위 밖에 있습니다.";
    private static final String LOWERCASE_EXCEPTION_MESSAGE = "문자열이 소문자로만 구성되어 있어야 합니다.";

    public static void validate(String cryptogram) {
        validateIsNotLowerCaseStr(cryptogram);
        validateNotInRange(cryptogram);
    }

    private static void validateIsNotLowerCaseStr(String cryptogram) {
        if (!Pattern.matches(LOWERCASE_STR_REGEXP, cryptogram)) {
            throw new IllegalArgumentException(LOWERCASE_EXCEPTION_MESSAGE);
        }
    }

    private static void validateNotInRange(String cryptogram) {
        if ((cryptogram.length() < MIN_LENGTH) || (cryptogram.length() > MAX_LENGTH)) {
            throw new IllegalArgumentException(LENGTH_EXCEPTION_MESSAGE);
        }
    }
}
