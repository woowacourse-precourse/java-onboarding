package onboarding.problem3.validation;

import onboarding.common.AbstractValidator;

/**
 * 주어진 int 값이 369 게임을 진행하기에 유효한 숫자인지 검증하는 작업을 모아둔 Validator 클래스입니다.
 * @author BackFoxx
 */
public class ThreeSixNineValidator extends AbstractValidator {
    public static final int MIN_RANGE = 1;
    public static final int MAX_RANGE = 10000;
    public static final String NUMBER = "number";

    /**
     * int 값을 검증하기 위해 외부에서 사용할 수 있는 유일한 메소드입니다.
     * 필요한 검증 작업을 호출하여 연속으로 실행할 수 있습니다.
     * 각 검증 작업에서 유효성 검사에 실패한 경우 예외가 발생합니다.
     * @param target 검증 대상인 int 를 인자로 받을 수 있습니다.
     */
    public static void validate(int target) {
        isNumberInValidRange(NUMBER, target, MIN_RANGE, MAX_RANGE);
    }
}
