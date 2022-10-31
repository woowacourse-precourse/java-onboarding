package onboarding.problem7.validation;

import onboarding.common.AbstractValidator;

import java.util.List;

/**
 * 입력값이 Visitors 일급 컬렉션을 만들기에 유효한 지 검증하는 작업을 모아둔 Validator 클래스입니다.
 * @author BackFoxx
 */
public class VisitorsValidator extends AbstractValidator {
    public static final int MIN_VISITORS_SIZE = 0;
    public static final int MAX_VISITORS_SIZE = 10_000;
    public static final String VISITORS = "Visitors";

    /**
     * 주어진 리스트를 검증하기 위해 외부에서 사용할 수 있는 유일한 메소드입니다.
     * 필요한 검증 작업을 호출하여 연속으로 실행할 수 있습니다.
     * 각 검증 작업에서 유효성 검사에 실패한 경우 예외가 발생합니다.
     * @param target 방문자의 이름으로 구성된 String 의 리스트입니다.
     */
    public static void validate(List<String> target) {
        isSizeOfListInValidRange(VISITORS, target, MIN_VISITORS_SIZE, MAX_VISITORS_SIZE);
    }
}
