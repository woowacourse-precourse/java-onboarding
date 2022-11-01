package onboarding.problem6.exception;

public class NotAllowDomainException extends RuntimeException {
    private static final String MESSAGE = "해당 도메인은 허용되지 않습니다.";

    public NotAllowDomainException() {
        super(MESSAGE);
    }
}
