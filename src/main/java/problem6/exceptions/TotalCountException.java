package problem6.exceptions;

public class TotalCountException extends RuntimeException{
    public TotalCountException() {
        super();
    }

    public TotalCountException(String message) {
        super(message);
    }
}
