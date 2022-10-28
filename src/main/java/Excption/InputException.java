package Excption;

/**
 * 입력값의 길이가 2이상인 예외
 */
public class InputException extends Exception {
    public InputException(String message) {
        super(message);
    }
}
