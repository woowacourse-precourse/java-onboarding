package onboarding.problem6.validation;

public class EmailValidation {
    private static final int MIN_EMAIL_LENGTH = 11;
    private static final int MAX_EMAIL_LENGTH = 19;
    private static final String EMAIL_REGEXP = "^[a-zA-Z0-9+-_.]+@email.com+$";
    private static final String EMAIL_FORMAT_EXCEPTION_MESSAGE = "이메일 형식은 [a-zA-Z0-9+-_.]@email.com입니다.";
    private static final String EMAIL_LENGTH_EXCEPTION_MESSAGE = "이메일은 11자 이상 20자 미만이어야 합니다.";

    public static void validate(String email) {
        validateEmailFormat(email);
        validateEmailLength(email);
    }

    private static void validateEmailFormat(String email) {
        if (!email.matches(EMAIL_REGEXP)) {
            throw new IllegalArgumentException(EMAIL_FORMAT_EXCEPTION_MESSAGE);
        }
    }

    private static void validateEmailLength(String email) {
        if ((email.length() < MIN_EMAIL_LENGTH) || (email.length() > MAX_EMAIL_LENGTH)) {
            throw new IllegalArgumentException(EMAIL_LENGTH_EXCEPTION_MESSAGE);
        }
    }
}
