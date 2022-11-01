package onboarding.problem7.exception;

public class FriendElementOutOfSizeException extends RuntimeException {
    private static final String MESSAGE = "친구 관계 요소의 수가 부힙하지 않습니다.";

    public FriendElementOutOfSizeException() {
        super(MESSAGE);
    }
}
