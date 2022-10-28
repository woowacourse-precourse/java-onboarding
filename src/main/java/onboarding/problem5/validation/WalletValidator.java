package onboarding.problem5.validation;

public class WalletValidator {
    public static final int MIN_RANGE = 1;
    public static final int MAX_RANGE = 1_000_000;
    public static final String INVALID_NUMBER_RANGE_MESSAGE_FORMAT = "입력값은 %d 이상 %d 이하의 자연수여야 합니다.";

    public static void validate(int target) {
        isNumberInValidRange(target);
    }

    private static void isNumberInValidRange(int number) {
        if (number < MIN_RANGE || MAX_RANGE < number) {
            throw new IllegalArgumentException(String.format(INVALID_NUMBER_RANGE_MESSAGE_FORMAT, MIN_RANGE, MAX_RANGE));
        }
    }
}
