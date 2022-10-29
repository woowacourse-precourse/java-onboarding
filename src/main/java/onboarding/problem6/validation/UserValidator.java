package onboarding.problem6.validation;

import java.util.List;

/**
 * 주어진 입력값이 User 와 관련한 작업을 하기에 유료한 지 검증하는 작업을 모아둔 Validator 클래스입니다.
 * @author BackFoxx
 */
public class UserValidator {
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

    /**
     * 문자열을 검증하기 위해 외부에서 사용할 수 있는 유일한 메소드입니다.
     * 필요한 검증 작업을 호출하여 연속으로 실행할 수 있습니다.
     * 각 검증 작업에서 유효성 검사에 실패한 경우 예외가 발생합니다.
     * @param target 이메일, 이름 문자열 두 개로 구성된 List<String> 의 리스트입니다.
     */
    public static void validate(List<List<String>> target) {
        isCountOfListValidRange(target);
        target.forEach(list -> {
            validateEmail(list.get(0));
            validateName(list.get(1));
        });
    }

    /**
     * User 중 name 값과 관련한 검증작업을 하는 메소드입니다.
     */
    private static void validateName(String name) {
        isNameLengthValidRange(name);
        isNameKorean(name);
    }

    /**
     * User 중 email 값과 관련한 검증작업을 하는 메소드입니다.
     */
    private static void validateEmail(String email) {
        isEmailLengthValidRange(email);
        isEmailValidFormat(email);
        isEmailDomain(email);
    }

    /**
     * name 문자열의 길이가 유효한 길이를 가지고 있는 지 검증하는 메소드입니다.
     */
    private static void isNameLengthValidRange(String name) {
        if (name.length() < MIN_NAME_LENGTH || MAX_NAME_LENGTH < name.length()) {
            throw new IllegalArgumentException(String.format(
                    INVALID_NAME_LENGTH_MESSAGE_FORMAT,
                    MIN_NAME_LENGTH,
                    MAX_NAME_LENGTH)
            );
        }
    }

    /**
     * name 문자열이 한글로 이루어져 있는 지 검증하는 메소드입니다.
     */
    private static void isNameKorean(String name) {
        if (!name.matches(KOREAN_REGEX)) {
            throw new IllegalArgumentException(EMAIL_NOT_KOREAN_MESSAGE);
        }
    }

    /**
     * email 문자열의 길이가 유효한 길이를 가지고 있는 지 검증하는 메소드입니다.
     */
    private static void isEmailLengthValidRange(String email) {
        if (email.length() < MIN_EMAIL_LENGTH || MAX_EMAIL_LENGTH < email.length()) {
            throw new IllegalArgumentException(String.format(
                    INVALID_EMAIL_LENGTH_FORMAT,
                    MIN_EMAIL_LENGTH,
                    MAX_EMAIL_LENGTH)
            );
        }
    }

    /**
     * email 문자열이 유효한 도메인을 가지고 있는 지 검증하는 메소드입니다.
     */
    private static void isEmailDomain(String email) {
        if (!email.endsWith(VALID_EMAIL_DOMAIN)) {
            throw new IllegalArgumentException(String.format(INVALID_EMAIL_DOMAIN_MESSAGE_FORMAT, VALID_EMAIL_DOMAIN));
        }
    }

    /**
     * email 문자열이 올바른 이메일 형식을 가지고 있는 지 검증하는 메소드입니다.
     */
    private static void isEmailValidFormat(String email) {
        if (!email.matches(EMAIL_REGEX)) {
            throw new IllegalArgumentException(INVALID_EMAIL_FORMAT_MESSAGE);
        }
    }

    /**
     * 주어진 크루들의 수가 유효한 범위 내에 있는 지 검증하는 메소드입니다.
     */
    private static void isCountOfListValidRange(List<List<String>> target) {
        if (target.size() < MIN_RANGE || MAX_RANGE < target.size()) {
            throw new IllegalArgumentException(String.format(INVALID_COUNT_RANGE_MESSAGE_FORMAT, MIN_RANGE, MAX_RANGE));
        }
    }
}
