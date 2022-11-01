package onboarding.problem2.exception;

public class ExistUpperCaseException extends RuntimeException{
    private static final String MESSAGE = "입력값에 대문자가 포함되어있습니다.";

    public ExistUpperCaseException() {
        super(MESSAGE);
    }
}
