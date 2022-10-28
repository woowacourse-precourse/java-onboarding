package onboarding.validatechecker;

public class Problem5ValidateChecker {
	public static void isNumberInRange(int number){
		if(number == 0 || number > 1000000)
			throw new IllegalArgumentException("입력 값은 1 이상 1,000,000 이하여야 합니다.");
	}
}
