package onboarding.problem7.exception;

public class IllegalRegexException extends RuntimeException{
    private static final String MESSAGE = "입력값이 포멧에 맞지 않습니다.";

    public IllegalRegexException() {
        super(MESSAGE);
    }
}
