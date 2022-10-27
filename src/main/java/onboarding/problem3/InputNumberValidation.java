package onboarding.problem3;

public class InputNumberValidation {

    public static void validateNumber(int number) {
        int MAX_VALUE = 10_000;
        int MIN_VALUE = 1;

        if (number < MIN_VALUE || MAX_VALUE < number) {
            throw new IllegalArgumentException("숫자는 1 이상 10,000 이하여야 합니다.");
        }
    }
}
