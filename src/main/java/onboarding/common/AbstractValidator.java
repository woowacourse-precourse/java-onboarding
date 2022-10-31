package onboarding.common;

import java.util.List;

public abstract class AbstractValidator {
    public static final String INVALID_NUMBER_RANGE_MESSAGE_FORMAT = "%s 값은 %d 이상 %d 이하의 수여야 합니다.";
    public static final String INVALID_STRING_LENGTH_RANGE_MESSAGE_FORMAT = "%s 값은 %d 이상 %d 이하의 길이로 주어져야 합니다.";
    public static final String INVALID_LIST_SIZE_RANGE_MESSAGE_FORMAT = "%s 값은 %d 이상 %d 이하 길이의 배열로 주어져야 합니다.";
    public static final String STRING_DISMATCH_TO_REGEX_MESSAGE_FORMAT = "%s 값이 '%s' 조건을 만족하지 않습니다.";

    public static final String ALPHABET_LOWERCASE_ONLY_DESCRIPTION = "오직 알파벳 소문자만 허용";
    public static final String ALPHABET_LOWERCASE_ONLY_REGEX = "^[a-z]*$";
    public static final String KOREAN_ONLY_DESCRIPTION = "오직 한글만 허용";
    public static final String KOREAN_ONLY_REGEX = "^[ㄱ-ㅣ가-힣]+$";
    public static final String EMAIL_DESCRIPTION = "이메일 형식";
    public static final String EMAIL_REGEX = "^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$";

    protected static void isNumberInValidRange(String name, int number, int min, int max) {
        if (number < min || max < number) {
            throw new IllegalArgumentException(String.format(INVALID_NUMBER_RANGE_MESSAGE_FORMAT, name, min, max));
        }
    }

    protected static void isStringLengthBetweenValidRange(String name, String target, int min, int max) {
        if (target == null || target.length() < min || max < target.length()) {
            throw new IllegalArgumentException(String.format(INVALID_STRING_LENGTH_RANGE_MESSAGE_FORMAT, name, min, max));
        }
    }

    protected static void isSizeOfListInValidRange(String name, List<?> target, int min, int max) {
        if (target == null || target.size() < min || max < target.size()) {
            throw new IllegalArgumentException(String.format(INVALID_LIST_SIZE_RANGE_MESSAGE_FORMAT, name, min, max));
        }
    }

    protected static void isStringMatchingToRegex(String name, String target, String regex, String regexDescription) {
        if (!target.matches(regex)) {
            throw new IllegalArgumentException(String.format(STRING_DISMATCH_TO_REGEX_MESSAGE_FORMAT, name, regexDescription));
        }
    }
}
