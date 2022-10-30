package onboarding.problem6;

import java.util.Collections;
import java.util.List;

public class Validation {
    private static final int MIN_NUMBER_OF_USERS = 1;
    private static final int MAX_NUMBER_OF_USERS = 10_000;
    private static final int MIN_EMAIL_LENGTH = 11;
    private static final int MAX_EMAIL_LENGTH = 19;
    private static final int MIN_NAME_LENGTH = 1;
    private static final int MAX_NAME_LENGTH = 19;
    private static final String EMAIL_REGEXP = "^[a-zA-Z0-9+-_.]+@email.com+$";
    private static final String NICK_NAME_REGEXP = "^[ㄱ-ㅎ|ㅏ-ㅣ|가-힣]+$";
    private static final String USERS_EXCEPTION_MESSAGE = "크루의 인원 수는 1 ~ 10,000이어야 합니다.";
    private static final String EMAIL_FORMAT_EXCEPTION_MESSAGE = "이메일 형식은 [a-zA-Z0-9+-_.]@email.com입니다.";
    private static final String EMAIL_LENGTH_EXCEPTION_MESSAGE = "이메일은 11자 이상 20자 미만이어야 합니다.";
    private static final String NAME_LANGUAGE_EXCEPTION_MESSAGE = "닉네임은 한글만 가능합니다.";
    private static final String NAME_LENGTH_EXCEPTION_MESSAGE = "닉네임은 1자 이상 20자 미만이어야 합니다.";

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

    private static void validateEmailLength(String email) {
        if ((email.length() < MIN_EMAIL_LENGTH) || (email.length() > MAX_EMAIL_LENGTH)) {
            throw new IllegalArgumentException(EMAIL_LENGTH_EXCEPTION_MESSAGE);
        }
    }

    private static void validateNickNameLanguage(String nickName) {
        if (!nickName.matches(NICK_NAME_REGEXP)) {
            throw new IllegalArgumentException(NAME_LANGUAGE_EXCEPTION_MESSAGE);
        }
    }
    private static void validateNickNameLength(String nickName) {
        if ((nickName.length() > MAX_NAME_LENGTH) || (nickName.length() < MIN_NAME_LENGTH)) {
            throw new IllegalArgumentException(NAME_LENGTH_EXCEPTION_MESSAGE);
        }
    }
}
