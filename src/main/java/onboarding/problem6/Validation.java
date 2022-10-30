package onboarding.problem6;

import java.util.Collections;
import java.util.List;

public class Validation {
    private static final int MIN_NUMBER_OF_USERS = 1;
    private static final int MAX_NUMBER_OF_USERS = 10_000;

    private static final String EMAIL_REGEXP = "^[a-zA-Z0-9+-_.]+@email.com+$";

    private static final String USERS_EXCEPTION_MESSAGE = "크루의 인원 수는 1 ~ 10,000이어야 합니다.";
    private static final String EMAIL_FORMAT_EXCEPTION_MESSAGE = "이메일 형식은 [a-zA-Z0-9+-_.]@email.com입니다.";


    private static void validateNumberOfUsers(List<List<String>> forms) {
        if ((forms.size() < MIN_NUMBER_OF_USERS) || (forms.size() > MAX_NUMBER_OF_USERS)) {
            throw new IllegalArgumentException(USERS_EXCEPTION_MESSAGE);
        }
    }

    private static void validateEmailFormat(String email) {
        if (!email.matches(EMAIL_REGEXP)) {
            throw new IllegalArgumentException(EMAIL_FORMAT_EXCEPTION_MESSAGE);
        }
    }
}
