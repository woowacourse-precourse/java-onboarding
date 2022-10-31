package onboarding.problem7.validation;

import onboarding.common.AbstractValidator;

public class UserValidator extends AbstractValidator {

    public static final String INVALID_ID_LENGTH_MESSAGE_FORMAT = "사용자 아이디의 길이는 %d 이상 %d 이하이어야 합니다.";
    public static final int MIN_ID_LENGTH_RANGE = 1;
    public static final int MAX_ID_LENGTH_RANGE = 30;
    public static final String INVALID_ID_FORMAT_MESSAGE = "사용자 아이디는 알파벳 소문자만 허용합니다.";
    public static final String ID_FORMAT_REGEX = "^[a-z]*$";

    @Override
    public boolean supports(Object target) {
        return target.getClass() == String.class;
    }

    @Override
    public void validate(Object target) {
        if (supports(target)) {
            validateUser((String) target);
        }
    }

    public static void validateUser(String user) {
        isIdLengthValid(user);
        isIdOnlyAlphabetLowerCase(user);
    }

    private static void isIdLengthValid(String id) {
        if (id == null || id.length() < MIN_ID_LENGTH_RANGE || MAX_ID_LENGTH_RANGE < id.length()) {
            throw new IllegalArgumentException(String.format(INVALID_ID_LENGTH_MESSAGE_FORMAT, MIN_ID_LENGTH_RANGE, MAX_ID_LENGTH_RANGE));
        }
    }

    private static void isIdOnlyAlphabetLowerCase(String id) {
        if (!id.matches(ID_FORMAT_REGEX)) {
            throw new IllegalArgumentException(INVALID_ID_FORMAT_MESSAGE);
        }
    }
}
