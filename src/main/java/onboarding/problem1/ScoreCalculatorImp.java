package onboarding.problem1;

import java.util.List;

public class ScoreCalculatorImp implements ScoreCalculator {
	private int getSum(int pageNumber) {
		int result = 0;
		while (pageNumber != 0) {
			result += pageNumber % 10;
			pageNumber /= 10;
		}
		return result;
	}

	private int getMultiplied(int pageNumber) {
		int result = 1;
		while (pageNumber != 0) {
			result *= pageNumber % 10;
			pageNumber /= 10;
		}
		return result;
	}

	@Override
	public int getScore(List<Integer> user) {
		int left = Math.max(getSum(user.get(0)), getMultiplied(user.get(0)));
		int right = Math.max(getSum(user.get(1)), getMultiplied(user.get(1)));
		return Math.max(left, right);
	}
}
