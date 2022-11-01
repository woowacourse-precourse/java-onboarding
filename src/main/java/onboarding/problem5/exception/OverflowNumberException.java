package onboarding.problem5.exception;

public class OverflowNumberException extends RuntimeException {
    private static final String MESSAGE = "정해진 숫자 범위를 초과되었습니다.";

    public OverflowNumberException() {
        super(MESSAGE);
    }
}
