package onboarding.problem4.exception;

public class MessageOutOfSizeException extends RuntimeException {
    private static final String MESSAGE = "텍스트 길이가 초과되었습니다.";

    public MessageOutOfSizeException() {
        super(MESSAGE);
    }
}
