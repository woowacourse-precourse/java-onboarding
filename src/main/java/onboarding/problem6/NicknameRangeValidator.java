package onboarding.problem6;

public class NicknameRangeValidator {

	public static final int MAX_SIZE = 20;
	public static final int MIN_SIZE = 0;

	public boolean validateRange(int range) {
		return range > MIN_SIZE && range < MAX_SIZE;
	}

}
