package onboarding.problem6.validation;

import onboarding.common.AbstractValidator;
import java.util.List;

/**
 * 주어진 입력값이 User 와 관련한 작업을 하기에 유효한 지 검증하는 작업을 모아둔 Validator 클래스입니다.
 * @author BackFoxx
 */
public class CrewValidator extends AbstractValidator {
    public static final String INVALID_EMAIL_DOMAIN_MESSAGE_FORMAT = "유효하지 않은 도메인입니다. (허용되는 도메인 : %s)";
    public static final String VALID_EMAIL_DOMAIN = "@email.com";
    public static final int USER_LIST_SIZE_MIN_RANGE = 1;
    public static final int USER_MIST_SIZE_MAX_RANGE = 10000;
    public static final int MIN_EMAIL_LENGTH = 11;
    public static final int MAX_EMAIL_LENGTH = 19;
    public static final int MIN_NAME_LENGTH = 1;
    public static final int MAX_NAME_LENGTH = 19;
    public static final String NAME = "Name";
    public static final String CREW = "Crew";
    public static final String EMAIL = "Email";

    /**
     * 문자열을 검증하기 위해 외부에서 사용할 수 있는 유일한 메소드입니다.
     * 필요한 검증 작업을 호출하여 연속으로 실행할 수 있습니다.
     * 각 검증 작업에서 유효성 검사에 실패한 경우 예외가 발생합니다.
     * @param target 크루의 이메일, 이름 문자열 두 개로 구성된 List<String> 의 리스트입니다.
     */
    public static void validate(List<List<String>> target) {
        isSizeOfListInValidRange(CREW, target, USER_LIST_SIZE_MIN_RANGE, USER_MIST_SIZE_MAX_RANGE);
        target.forEach(crew -> {
            validateEmail(crew.get(0));
            validateName(crew.get(1));
        });
    }

    /**
     * Crew 중 name 값과 관련한 검증작업을 하는 메소드입니다.
     */
    private static void validateName(String name) {
        isStringLengthBetweenValidRange(NAME, name, MIN_NAME_LENGTH, MAX_NAME_LENGTH);
        isStringMatchingToRegex(NAME, name, KOREAN_ONLY_REGEX, KOREAN_ONLY_DESCRIPTION);
    }

    /**
     * Crew 중 email 값과 관련한 검증작업을 하는 메소드입니다.
     */
    private static void validateEmail(String email) {
        isStringLengthBetweenValidRange(EMAIL, email, MIN_EMAIL_LENGTH, MAX_EMAIL_LENGTH);
        isStringMatchingToRegex(EMAIL, email, EMAIL_REGEX, EMAIL_DESCRIPTION);
        hasValidEmailDomain(email);
    }

    /**
     * email 문자열이 유효한 도메인을 가지고 있는 지 검증하는 메소드입니다.
     */
    private static void hasValidEmailDomain(String email) {
        if (!email.endsWith(VALID_EMAIL_DOMAIN)) {
            throw new IllegalArgumentException(String.format(INVALID_EMAIL_DOMAIN_MESSAGE_FORMAT, VALID_EMAIL_DOMAIN));
        }
    }
}
