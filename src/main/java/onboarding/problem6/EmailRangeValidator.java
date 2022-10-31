package onboarding.problem6;

public class EmailRangeValidator {

	public static final int MAX_SIZE = 20;
	public static final int MIN_SIZE = 11;

	public boolean validatorRange(int range) {
		return range >= MIN_SIZE && range < MAX_SIZE;
	}
}
