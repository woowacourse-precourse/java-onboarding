package onboarding.problem7.exception;

public class VisitorArrayOutOfSizeException extends RuntimeException {
    private static final String MESSAGE = "방문자 요소 수가 기준에 부합하지 않습니다.";

    public VisitorArrayOutOfSizeException() {
        super(MESSAGE);
    }
}
