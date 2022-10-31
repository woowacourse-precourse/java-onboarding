package problem6.exceptions;

public class NameFormatException extends RuntimeException {
    public NameFormatException() {
        super();
    }

    public NameFormatException(String message) {
        super(message);
    }
}
