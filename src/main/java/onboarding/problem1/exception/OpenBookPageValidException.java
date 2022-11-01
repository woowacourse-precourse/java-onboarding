package onboarding.problem1.exception;

public class OpenBookPageValidException extends GameRuntimeException {
    public OpenBookPageValidException(OpenBookPageValid openBookPageValid) {
        super(openBookPageValid.getMessage());
    }
}
