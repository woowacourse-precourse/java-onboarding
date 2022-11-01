package onboarding.newExceptions;

public class InvalidStringException extends RuntimeException{

    InvalidStringException(){

    }

    public InvalidStringException(String message){
        super(message);
    }
}
