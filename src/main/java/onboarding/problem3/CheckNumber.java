package onboarding.problem3;

public class CheckNumber {
	private final static int MAX_SIZE = 1000;
	private final static int MIN_SIZE = 1;

	public static boolean of(int number) {
		return number >= MIN_SIZE && number <= MAX_SIZE;
	}
}
