package onboarding;

import java.util.Collections;
import java.util.List;

public class Problem5 {

	public static List<Integer> solution(int money) {
		List<Integer> answer = Collections.emptyList();
		return answer;
	}

	static class InputValidator {
		private static boolean isRightMoneyRange(int money) {
			if (money < 1 || money > 1000000) {
				return false;
			}
			return true;
		}
	}
}
