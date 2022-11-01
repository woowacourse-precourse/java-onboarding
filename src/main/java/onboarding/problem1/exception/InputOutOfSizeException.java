package onboarding.problem1.exception;

public class InputOutOfSizeException extends GameRuntimeException {
    private static final String MESSAGE = "메시지의 길이가 기준에 부합하지 않습니다.";

    public InputOutOfSizeException() {
        super(MESSAGE);
    }
}
