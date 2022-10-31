package onboarding.problem7.validation;

public class UserValidation {
    private static final String USER_LENGTH_EXCEPTION_MESSAGE = "유저의 아이디 길이는 1이상 30이하여야 합니다.";
    private static final String USER_LOWERCASE_EXCEPTION_MESSAGE = "유저의 아이디 길이는 소문자로 구성되어야 합니다.";

    public static void validate(String user) {
        if (!IdValidation.validateIdLengthInRange(user)) {
            throw new IllegalArgumentException(USER_LENGTH_EXCEPTION_MESSAGE);
        }
        if (!IdValidation.validateIsLowerCaseId(user)) {
            throw new IllegalArgumentException(USER_LOWERCASE_EXCEPTION_MESSAGE);
        }
    }
}
