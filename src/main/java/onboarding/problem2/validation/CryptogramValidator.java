package onboarding.problem2.validation;

import onboarding.common.AbstractValidator;

/**
 * 괴짜 개발자 브라운의 암호문 해독 알고리즘을 실행하기에 유효한 문자열인지 검증하는 작업을 모아둔 Validator 클래스입니다.
 * @author BackFoxx
 */
public class CryptogramValidator extends AbstractValidator {
    public static final String STRING_NOT_LOWERCASE_MESSAGE = "문자열은 소문자로만 이루어져야 합니다.";

    public static final int MIN_LENGTH = 1;
    public static final int MAX_LENGTH = 1000;
    public static final String CRYPTOGRAM = "Cryptogram";

    /**
     * Pages 객체를 검증하기 위해 외부에서 사용할 수 있는 유일한 메소드입니다.
     * 필요한 검증 작업을 호출하여 연속으로 실행할 수 있습니다.
     * 각 검증 작업에서 유효성 검사에 실패한 경우 예외가 발생합니다.
     * @param target 검증 대상인 문자열을 인자로 받을 수 있습니다.
     */
    public static void validate(String target) {
        isStringLengthBetweenValidRange(CRYPTOGRAM, target, MIN_LENGTH, MAX_LENGTH);
        isWordLowerCase(target);
    }

    /**
     * 인자로 넘어온 문자열이 전부 소문자로 이루어져 있는지 검증합니다.
     */
    private static void isWordLowerCase(String target) {
        if (!target.equals(target.toLowerCase())) {
            throw new IllegalArgumentException(STRING_NOT_LOWERCASE_MESSAGE);
        }
    }
}
