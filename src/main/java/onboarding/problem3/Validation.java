package onboarding.problem3;

public class Validation {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 10_000;
    private static final String RANGE_EXCEPTION_MESSAGE = "숫자는 1부터 10,000사이에 입력되어야 합니다.";

    public static void validate(int number) {
        validateInRange(number);
    }

    private static void validateInRange(int number) {
        if ((number < MIN_NUMBER) || (number > MAX_NUMBER)) {
            throw new IllegalArgumentException(RANGE_EXCEPTION_MESSAGE);
        }
    }
}
