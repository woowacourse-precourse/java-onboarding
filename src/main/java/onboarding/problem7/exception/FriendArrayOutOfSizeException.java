package onboarding.problem7.exception;

public class FriendArrayOutOfSizeException extends RuntimeException {
    private static final String MESSAGE = "친구 관계 수의 범위가 부합하지 않습니다.";

    public FriendArrayOutOfSizeException() {
        super(MESSAGE);
    }
}
