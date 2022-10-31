package onboarding.problem4;

public class WordsRangeValidator {

	public static final int MIN_SIZE = 0;
	public static final int MAX_SIZE = 1000;

	public boolean validate(int range) {
		return range > MIN_SIZE && range <= MAX_SIZE;
	}
}
