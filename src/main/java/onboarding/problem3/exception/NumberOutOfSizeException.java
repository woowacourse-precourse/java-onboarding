package onboarding.problem3.exception;

public class NumberOutOfSizeException extends RuntimeException {
    private static final String MESSAGE = "정해진 숫자 범위를 초과되었습니다.";

    public NumberOutOfSizeException() {
        super(MESSAGE);
    }
}
