package onboarding.problem7.validation;

import onboarding.common.AbstractValidator;

public class UserValidator extends AbstractValidator {

    public static final int MIN_ID_LENGTH_RANGE = 1;
    public static final int MAX_ID_LENGTH_RANGE = 30;
    public static final String USER_ID = "user id";

    public static void validate(String user) {
        isStringLengthBetweenValidRange(USER_ID, user, MIN_ID_LENGTH_RANGE, MAX_ID_LENGTH_RANGE);
        isStringMatchingToRegex(USER_ID, user, ALPHABET_LOWERCASE_ONLY_REGEX, ALPHABET_LOWERCASE_ONLY_DESCRIPTION);
    }
}
