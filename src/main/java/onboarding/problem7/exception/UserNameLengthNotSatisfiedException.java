package onboarding.problem7.exception;

public class UserNameLengthNotSatisfiedException extends RuntimeException {
    private static final String MESSAGE = "유저 이름의 길이가 존재하지 않습니다.";

    public UserNameLengthNotSatisfiedException() {
        super(MESSAGE);
    }
}
