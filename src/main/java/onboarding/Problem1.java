package onboarding;

import java.util.List;

import onboarding.problem1.PageNumberGame;
import onboarding.problem1.Validator;

class Problem1 {
	public static int solution(List<Integer> pobi, List<Integer> crong) {
		try {
			Validator.validate(pobi);
			Validator.validate(crong);
		} catch (IllegalArgumentException e) {
			return PageNumberGame.EXCEPTION;
		}
		return PageNumberGame.start(pobi, crong);
	}
}
