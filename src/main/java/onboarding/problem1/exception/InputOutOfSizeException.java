package onboarding.problem1.exception;

public class InputOutOfSizeException extends GameRuntimeException {
    private static final String MESSAGE = "입력값이 초과되었습니다. 입력값은 2 이하여야 합니다.";

    public InputOutOfSizeException() {
        super(MESSAGE);
    }
}
