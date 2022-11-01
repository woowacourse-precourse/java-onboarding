package onboarding.common;

import java.util.List;

/**
 * 검증 클래스에서 자주 사용되는 검증 메소드를 모아놓은 추상 클래스입니다.
 * @author BackFoxx
 */
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

    /**
     * 주어진 int 값이 유효한 범위 내의 값인 지 검증합니다.
     * @param name 주어진 int 값의 이름입니다.
     * @param number 검증할 int 값입니다.
     * @param min 유효범위의 최소값입니다. number 값은 min 보다 크거나 같아야 합니다.
     * @param max 유효범위의 최대값입니다. number 값은 max 보다 작거나 같아야 합니다.
     */
    protected static void isNumberInValidRange(String name, int number, int min, int max) {
        if (number < min || max < number) {
            throw new IllegalArgumentException(String.format(INVALID_NUMBER_RANGE_MESSAGE_FORMAT, name, min, max));
        }
    }

    /**
     * 주어진 문자열의 길이가 유효 범위 내에 있는 지 검증합니다.
     * @param name 주어진 문자열의 이름입니다.
     * @param target 검증할 문자열입니다.
     * @param min 유효범위의 최소값입니다. target 의 길이 값은 min 보다 크거나 같아야 합니다.
     * @param max 유효범위의 최대값입니다. target 의 길이 값은 max 보다 작거나 같아야 합니다.
     */
    protected static void isStringLengthBetweenValidRange(String name, String target, int min, int max) {
        if (target == null || target.length() < min || max < target.length()) {
            throw new IllegalArgumentException(String.format(INVALID_STRING_LENGTH_RANGE_MESSAGE_FORMAT, name, min, max));
        }
    }

    /**
     * 주어진 배열의 원소 개수가 유효 범위 내에 있는 지 검증합니다.
     * @param name 주어진 배열의 이름입니다.
     * @param target 검증할 배열입니다.
     * @param min 유효범위의 최소값입니다. target 의 원소 개수 값은 min 보다 크거나 같아야 합니다.
     * @param max 유효범위의 최대값입니다. target 의 원소 개수 값은 max 보다 작거나 같아야 합니다.
     */
    protected static void isSizeOfListInValidRange(String name, List<?> target, int min, int max) {
        if (target == null || target.size() < min || max < target.size()) {
            throw new IllegalArgumentException(String.format(INVALID_LIST_SIZE_RANGE_MESSAGE_FORMAT, name, min, max));
        }
    }

    /**
     * 주어진 문자열이 주어진 정규식과 매칭되는 지 검증합니다.
     * @param name 주어진 문자열의 이름입니다.
     * @param target 검증할 문자열입니다.
     * @param regex 문자열을 검증할 때 사용할 정규식입니다.
     * @param regexDescription 주어진 정규식에 대한 설명입니다.
     */
    protected static void isStringMatchingToRegex(String name, String target, String regex, String regexDescription) {
        if (!target.matches(regex)) {
            throw new IllegalArgumentException(String.format(STRING_DISMATCH_TO_REGEX_MESSAGE_FORMAT, name, regexDescription));
        }
    }
}
