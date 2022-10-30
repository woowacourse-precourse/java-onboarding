package onboarding.problem6.exception;

public class SizeOutOfRangeException extends Exception {
	public SizeOutOfRangeException() { 	}

	public SizeOutOfRangeException(String errorMessage) {
		super(errorMessage);
	}
}
