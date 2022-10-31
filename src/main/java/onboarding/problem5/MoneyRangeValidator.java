package onboarding.problem5;

public class MoneyRangeValidator {

	public static final int MIN_SIZE = 0;
	public static final int MAX_SIZE = 1_000_000;

	public boolean validate(int n) {
		return n > MIN_SIZE && n <= MAX_SIZE;
	}
}
