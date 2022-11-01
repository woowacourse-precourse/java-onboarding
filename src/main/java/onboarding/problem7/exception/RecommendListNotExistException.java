package onboarding.problem7.exception;

public class RecommendListNotExistException extends RuntimeException {
    private static final String MESSAGE = "추천 친구가 존재하지 않습니다.";

    public RecommendListNotExistException() {
        super(MESSAGE);
    }
}
