package onboarding;

import onboarding.problem3.Game369;
import onboarding.problem3.NumberRangeValidator;

public class Problem3 {

	public static final String GUIDE = "number는 1 이상 10,000 이하인 자연수이여야 한다.";

	public static int solution(int number) {
		NumberRangeValidator numberRangeValidator = new NumberRangeValidator();
		if (!numberRangeValidator.validate(number)) {
			throw new IllegalArgumentException(GUIDE);
		}
		Game369 game369 = new Game369();
		return game369.getCount(number);
	}
}
