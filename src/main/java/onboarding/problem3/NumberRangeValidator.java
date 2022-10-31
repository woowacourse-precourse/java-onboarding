package onboarding.problem3;

public class NumberRangeValidator {

	public static final int MAX_NUMBER = 10000;
	public static final int MIN_NUMBER = 1;

	public boolean validate(int number) {
		return number >= MIN_NUMBER && number <= MAX_NUMBER;
	}
}
