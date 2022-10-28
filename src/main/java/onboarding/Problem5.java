package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
	private static final int[] UNIT_OF_MONEY = new int[] {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

	public static List<Integer> solution(int money) {
		List<Integer> answer = Collections.emptyList();
		answer = getResults(money);
		return answer;
	}

	private static List<Integer> getResults(int money) {
		if (!InputValidator.isRightMoneyRange(money)) {
			throw new IllegalArgumentException();
		}

		List<Integer> results = new ArrayList<Integer>();
		for (int unit : UNIT_OF_MONEY) {
			results.add(divideMoney(money, unit));
			money = getRemainingMoney(money, unit);
		}
		return results;
	}

	private static int divideMoney(int money, int unit) {
		return money / unit;
	}

	private static int getRemainingMoney(int money, int unit) {
		return money % unit;
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
