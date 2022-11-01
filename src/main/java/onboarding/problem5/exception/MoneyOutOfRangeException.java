package onboarding.problem5.exception;

public class MoneyOutOfRangeException extends Exception {
	public MoneyOutOfRangeException() {	}

	public MoneyOutOfRangeException(String errorMessage) {
		super(errorMessage);
	}
}
