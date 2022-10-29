package onboarding.problem5.validation;

/**
 * 지갑에 돈을 저장하기에 유효한 값인 지 검증하는 작업을 모아둔 Validator 클래스입니다.
 * @author BackFoxx
 */
public class WalletValidator {
    public static final int MIN_RANGE = 1;
    public static final int MAX_RANGE = 1_000_000;
    public static final String INVALID_NUMBER_RANGE_MESSAGE_FORMAT = "입력값은 %d 이상 %d 이하의 자연수여야 합니다.";

    /**
     * 값을 검증하기 위해 외부에서 사용할 수 있는 유일한 메소드입니다.
     * 필요한 검증 작업을 호출하여 연속으로 실행할 수 있습니다.
     * 각 검증 작업에서 유효성 검사에 실패한 경우 예외가 발생합니다.
     * @param target 검증 대상인 int 값을 인자로 받을 수 있습니다.
     */
    public static void validate(int target) {
        isNumberInValidRange(target);
    }

    /**
     * 인자로 넘어온 int 값이 유효한 숫자 범위 내에 있는 지 검증합니다.
     */
    private static void isNumberInValidRange(int number) {
        if (number < MIN_RANGE || MAX_RANGE < number) {
            throw new IllegalArgumentException(String.format(INVALID_NUMBER_RANGE_MESSAGE_FORMAT, MIN_RANGE, MAX_RANGE));
        }
    }
}
