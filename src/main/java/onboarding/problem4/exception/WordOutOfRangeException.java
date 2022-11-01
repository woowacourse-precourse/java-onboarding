package onboarding.problem4.exception;

public class WordOutOfRangeException extends Exception {
	public WordOutOfRangeException() {	}

	public WordOutOfRangeException(String errorMessage) {
		super(errorMessage);
	}
}
