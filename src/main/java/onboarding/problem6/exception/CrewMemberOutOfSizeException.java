package onboarding.problem6.exception;

public class CrewMemberOutOfSizeException extends RuntimeException {
    private static final String MESSAGE = "등록된 크루 수가 기준에 부합하지 않습니다.";

    public CrewMemberOutOfSizeException() {
        super(MESSAGE);
    }
}
