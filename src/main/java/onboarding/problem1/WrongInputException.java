package onboarding.problem1;

/**
 * Exception to input value error
 */
public class WrongInputException extends Exception {
    WrongInputException(String msg) {
        super(msg);
    }
}
