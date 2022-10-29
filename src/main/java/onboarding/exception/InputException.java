package onboarding.exception;

public class InputException extends RuntimeException {

    public InputException(ExceptionMessage exceptionMessage){
        super(exceptionMessage.getErrorMessage());
    }
}
