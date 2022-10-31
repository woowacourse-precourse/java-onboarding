package onboarding;

import java.util.List;

import onboarding.problem1.PageMaxCalculator;
import onboarding.problem1.PageValidator;

class Problem1 {
	public static int solution(List<Integer> pobi, List<Integer> crong) {
		PageValidator pageValidator = new PageValidator();
		if (!(pageValidator.validate(pobi) && pageValidator.validate(crong))) {
			return -1;
		}

		PageMaxCalculator pageMaxCalculator = new PageMaxCalculator();
		return Integer.compare(pageMaxCalculator.findMax(pobi), pageMaxCalculator.findMax(crong));
	}
}
