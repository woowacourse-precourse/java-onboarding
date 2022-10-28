package Excption;

/**
 * 페이지가 1~400이 아닌경우
 */
public class PageException extends Exception {
    public PageException(String message) {
        super(message);
    }
}
