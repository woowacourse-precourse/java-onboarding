package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Problem1 {
	public static int solution(List<Integer> pobi, List<Integer> crong) {
		if (isWrongNumber(pobi) || isWrongNumber(crong)) {
			return -1;
		}

		int pobiScore = getScore(pobi);
		int crongScore = getScore(crong);

		return compareValues(pobiScore, crongScore);
	}

	private static int compareValues(int a, int b) {
		if (a > b) {
			return 1;
		} else if (a < b) {
			return 2;
		}
		return 0;
	}

	private static boolean isWrongNumber(List<Integer> pages) {
		int left = pages.get(0);
		int right = pages.get(1);

		return left == 1 || right == 400 || right - left != 1;
	}

	private static int getScore(List<Integer> pages) {
		List<Integer> scores = new ArrayList<>();

		for (Integer page : pages) {
			List<Integer> digits = getDigit(page);
			scores.add(getValues(digits));
		}

		return Collections.max(scores);
	}

	private static List<Integer> getDigit(int number) {
		ArrayList<Integer> arrNum = new ArrayList<>();

		while (number > 0) {
			arrNum.add(number % 10);
			number /= 10;
		}

		return arrNum;
	}

	private static int getValues(List<Integer> values) {
		int valueSum = 0;
		int valueMultiple = 1;

		for (int value : values) {
			valueSum += value;
			valueMultiple *= value;
		}

		return Math.max(valueSum, valueMultiple);
	}
}
