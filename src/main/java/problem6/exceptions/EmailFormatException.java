package problem6.exceptions;

public class EmailFormatException extends RuntimeException {
    public EmailFormatException() {
        super();
    }

    public EmailFormatException(String message) {
        super(message);
    }
}
