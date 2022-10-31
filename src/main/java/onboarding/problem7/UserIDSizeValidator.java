package onboarding.problem7;

public class UserIDSizeValidator {
	public static final int MIN_SIZE = 0;
	public static final int MAX_SIZE = 30;

	public boolean validate(int size) {
		return size <= MAX_SIZE && size > MIN_SIZE;
	}
}
