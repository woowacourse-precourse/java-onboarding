package onboarding.problem5.util;

public class MoneyInputValidator {
	public static boolean rangeValidator(int money) {
		boolean result = money >= 1 && money <= 1_000_000;
		if (!result) throw new IllegalArgumentException("입력한 money는 1 이상 1,000,000 이하인 자연수여야 합니다.");
		return result;
	}
}
