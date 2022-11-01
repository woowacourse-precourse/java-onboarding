package onboarding.problem1.exception;

public abstract class GameRuntimeException extends RuntimeException {
    public GameRuntimeException(String message) {
        super(message);
    }
}
