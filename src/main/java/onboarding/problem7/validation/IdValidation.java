package onboarding.problem7.validation;

import java.util.regex.Pattern;

public class IdValidation {
    private static final int MAX_ID_LENGTH = 30;
    private static final int MIN_ID_LENGTH = 1;
    private static final String LOWERCASE_STR_REGEXP = "^[a-z]+$";

    public static boolean validateIdLengthInRange(String id) {
        return (id.length() >= MIN_ID_LENGTH) && (id.length() <= MAX_ID_LENGTH);
    }

    public static boolean validateIsLowerCaseId(String id) {
        return Pattern.matches(LOWERCASE_STR_REGEXP, id);
    }
}
