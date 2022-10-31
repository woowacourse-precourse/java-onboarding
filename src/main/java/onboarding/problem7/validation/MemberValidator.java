package onboarding.problem7.validation;

import onboarding.common.AbstractValidator;

/**
 * 입력값이 Member 객체를 만들기에 유효한 지,
 * Member 객체를 만들지 않더라도 입력값이 '사용자'의 조건에 부합하는 지
 * 검증하는 작업을 모아둔 Validator 클래스입니다.
 * @author BackFoxx
 */
public class MemberValidator extends AbstractValidator {

    public static final int MIN_ID_LENGTH_RANGE = 1;
    public static final int MAX_ID_LENGTH_RANGE = 30;
    public static final String USER_ID = "user id";

    /**
     * 주어진 문자열을 검증하기 위해 외부에서 사용할 수 있는 유일한 메소드입니다.
     * 필요한 검증 작업을 호출하여 연속으로 실행할 수 있습니다.
     * 각 검증 작업에서 유효성 검사에 실패한 경우 예외가 발생합니다.
     * @param target 사용자의 id 값이 담긴 문자열입니다.
     */
    public static void validate(String target) {
        isStringLengthBetweenValidRange(USER_ID, target, MIN_ID_LENGTH_RANGE, MAX_ID_LENGTH_RANGE);
        isStringMatchingToRegex(USER_ID, target, ALPHABET_LOWERCASE_ONLY_REGEX, ALPHABET_LOWERCASE_ONLY_DESCRIPTION);
    }
}
