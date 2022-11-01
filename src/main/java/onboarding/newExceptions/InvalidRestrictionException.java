package onboarding.newExceptions;

public class InvalidRestrictionException extends RuntimeException{

    InvalidRestrictionException(){

    }

    public InvalidRestrictionException(String message){
        super(message);
    }
}
