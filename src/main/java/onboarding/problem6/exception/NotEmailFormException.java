package onboarding.problem6.exception;

public class NotEmailFormException extends RuntimeException {
    private static final String MESSAGE = "이메일 형식이 부합하지 않습니다.";

    public NotEmailFormException() {
        super(MESSAGE);
    }
}
