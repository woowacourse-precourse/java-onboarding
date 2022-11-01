package onboarding.problem6.exception;

public class CrewFormOutOfSizeException extends RuntimeException {
    private static final String MESSAGE = "크루 형식의 크기가 기준에 부합하지 않습니다.";

    public CrewFormOutOfSizeException() {
        super(MESSAGE);
    }
}
