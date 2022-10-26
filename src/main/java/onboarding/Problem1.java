package onboarding;

import java.util.List;

class Problem1 {
	private static int maxValue(int value1, int value2) {
		if (value1 >= value2) {
			return value1;
		}
		return value2;
	}

	private static int sumEachInt(int value) {
		int sumInt = 0;
		while (value > 0) {
			sumInt += value % 10;
			value /= 10;
		}
		return sumInt;
	}

	private static int multipleEachInt(int value) {
		int multipleInt = 1;
		while (value > 1) {
			multipleInt *= (value % 10);
			value /= 10;
		}
		return multipleInt;
	}

	private static int bigPageResult(List<Integer> person) {
		int leftPage = person.get(0);
		int rightPage = person.get(1);

		int bigLeftPage = maxValue(sumEachInt(leftPage), multipleEachInt(rightPage));
		int bigRightPage = maxValue(sumEachInt(rightPage), multipleEachInt(rightPage));

		return maxValue(bigLeftPage, bigRightPage);
	}

	public static int solution(List<Integer> pobi, List<Integer> crong) {
		int answer = Integer.MAX_VALUE;

		return answer;
	}
}