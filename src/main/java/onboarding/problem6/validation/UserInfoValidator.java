package onboarding.problem6.validation;

import java.util.List;

public class UserInfoValidator {
    public static final String INVALID_COUNT_RANGE_MESSAGE_FORMAT = "크루 수는 %d명 이상 %d명 이하여야 합니다.";
    public static final String INVALID_EMAIL_FORMAT_MESSAGE = "유효한 이메일 형식에 부합하지 않습니다.";
    public static final String INVALID_EMAIL_DOMAIN_MESSAGE_FORMAT = "유효하지 않은 도메인입니다. (허용되는 도메인 : %s)";
    public static final int MIN_RANGE = 1;
    public static final int MAX_RANGE = 10000;
    public static final String VALID_EMAIL_DOMAIN = "@email.com";
    public static final int MIN_EMAIL_LENGTH = 11;
    public static final int MAX_EMAIL_LENGTH = 19;
    public static final String EMAIL_NOT_KOREAN_MESSAGE = "닉네임은 한글로 작성해야 합니다.";
    public static final int MIN_NAME_LENGTH = 1;
    public static final int MAX_NAME_LENGTH = 19;
    public static final String INVALID_NAME_LENGTH_MESSAGE_FORMAT = "닉네임 길이는 %d자 이상 %d자 미만이어야 합니다.";
    public static final String INVALID_EMAIL_LENGTH_FORMAT = "이메일 길이는 %d자 이상 %d자 미만이어야 합니다.";
    public static final String KOREAN_REGEX = "^[ㄱ-ㅣ가-힣]+$";
    public static final String EMAIL_REGEX = "^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$";

    public static void validate(List<List<String>> target) {
        isCountOfListValidRange(target);
        target.forEach(list -> {
            validateEmail(list.get(0));
            validateName(list.get(1));
        });
    }

    private static void validateName(String name) {
        isNameLengthValidRange(name);
        isNameKorean(name);
    }

    private static void validateEmail(String email) {
        isEmailLengthValidRange(email);
        isEmailValidFormat(email);
        isEmailDomain(email);
    }

    private static void isNameLengthValidRange(String name) {
        if (name.length() < MIN_NAME_LENGTH || MAX_NAME_LENGTH < name.length()) {
            throw new IllegalArgumentException(String.format(
                    INVALID_NAME_LENGTH_MESSAGE_FORMAT,
                    MIN_NAME_LENGTH,
                    MAX_NAME_LENGTH)
            );
        }
    }

    private static void isNameKorean(String name) {
        if (!name.matches(KOREAN_REGEX)) {
            throw new IllegalArgumentException(EMAIL_NOT_KOREAN_MESSAGE);
        }
    }

    private static void isEmailLengthValidRange(String email) {
        if (email.length() < MIN_EMAIL_LENGTH || MAX_EMAIL_LENGTH < email.length()) {
            throw new IllegalArgumentException(String.format(
                    INVALID_EMAIL_LENGTH_FORMAT,
                    MIN_EMAIL_LENGTH,
                    MAX_EMAIL_LENGTH)
            );
        }
    }

    private static void isEmailDomain(String email) {
        if (!email.endsWith(VALID_EMAIL_DOMAIN)) {
            throw new IllegalArgumentException(String.format(INVALID_EMAIL_DOMAIN_MESSAGE_FORMAT, VALID_EMAIL_DOMAIN));
        }
    }

    private static void isEmailValidFormat(String email) {
        if (!email.matches(EMAIL_REGEX)) {
            throw new IllegalArgumentException(INVALID_EMAIL_FORMAT_MESSAGE);
        }
    }

    private static void isCountOfListValidRange(List<List<String>> target) {
        if (target.size() < MIN_RANGE || MAX_RANGE < target.size()) {
            throw new IllegalArgumentException(String.format(INVALID_COUNT_RANGE_MESSAGE_FORMAT, MIN_RANGE, MAX_RANGE));
        }
    }
}
