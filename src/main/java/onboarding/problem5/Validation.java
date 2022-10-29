package onboarding.problem5;

public class Validation {
    private static final int MIN_MONEY = 1;
    private static final int MAX_MONEY = 1_000_000;
    private static final String RANGE_EXCEPTION_MESSAGE = "money는 1 이상 1,000,000이하여야 합니다.";

    public static void validate(int money) {
        validateInRange(money);
    }

    private static void validateInRange(int money) {
        if ((money < MIN_MONEY) || (money > MAX_MONEY)) {
            throw new IllegalArgumentException(RANGE_EXCEPTION_MESSAGE);
        }
    }
}
