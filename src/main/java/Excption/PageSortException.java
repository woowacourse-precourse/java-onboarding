package Excption;

/**
 * 페이지가 연속적인 범위가 아닌경우
 */
public class PageSortException extends Exception{
    public PageSortException(String message) {
        super(message);
    }
}
