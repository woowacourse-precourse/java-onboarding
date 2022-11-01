package onboarding.problem4.exception;

public class CharacterCategoryMismatchException extends Exception{
	public CharacterCategoryMismatchException() {	}

	public CharacterCategoryMismatchException(String errorMessage) {
		super(errorMessage);
	}
}
