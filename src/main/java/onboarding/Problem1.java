package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {
	public static int solution(List<Integer> pobi, List<Integer> crong) {
		if (!(checkNumber(pobi) && checkNumber(crong))) {
			return -1;
		}

		int pobiScore = getScore(pobi);
		int crongScore = getScore(crong);

		if (pobiScore > crongScore) {
			return 1;
		} else if (pobiScore < crongScore) {
			return 2;
		} else {
			return 0;
		}
	}

	private static boolean checkNumber(List<Integer> pages) {
		int left = pages.get(0);
		int right = pages.get(1);

		return !(left == 1 || right == 400 || left != right - 1);
	}

	private static int getScore(List<Integer> pages) {

		int left = pages.get(0);
		int right = pages.get(1);

		List<Integer> leftDigits = getDigit(left);
		List<Integer> rightDigits = getDigit(right);

		int leftScore = getValues(leftDigits);
		int rightScore = getValues(rightDigits);

		int score = Math.max(leftScore, rightScore);

		return score;
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

		for (int v : values) {
			valueSum += v;
			valueMultiple *= v;
		}

		int value = Math.max(valueSum, valueMultiple);

		return value;
	}
}
