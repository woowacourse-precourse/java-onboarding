package Exception;

/**
 * 페이지가 1~400이 아닌경우
 */
public class RangeException extends Exception {
    public RangeException(String message) {
        super(message);
    }
}
