package onboarding.problem2;

public class CryptogramRangeValidator {

	public static final int MAX_SIZE = 1000;
	public static final int MIN_SIZE = 0;

	public boolean validate(int size) {
		return size > MIN_SIZE && size <= MAX_SIZE;
	}
}
