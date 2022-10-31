package onboarding;

import java.util.List;

class Problem1 {
	static final int POBI_IS_WINNER = 1;
	static final int CRONG_IS_WINNER = 2;
	static final int DRAW = 0;
	static final int EXCEPTION = -1;

	static final int LEFT_PAGE = 0;
	static final int RIGHT_PAGE = 1;

	static final int MINIMUM_PAGE_NUMBER = 3;
	static final int MAXIMUM_PAGE_NUMBER = 398;

	public static int solution(List<Integer> pobi, List<Integer> crong) {
		return returnResult(pobi, crong);
	}

	private static int returnResult(List<Integer> pobi, List<Integer> crong) {
		if (isInvalidInput(pobi) || isInvalidInput(crong)) {
			return EXCEPTION;
		}
		if (selectSide(pobi) > selectSide(crong)) {
			return POBI_IS_WINNER;
		}
		if (selectSide(pobi) < selectSide(crong)) {
			return CRONG_IS_WINNER;
		}
		return DRAW;
	}

	private static boolean isInvalidInput(List<Integer> pageList) {
		return isInvalidRange(pageList) || isNotContiguous(pageList) || isInvalidParity(pageList);
	}

	private static boolean isInvalidParity(List<Integer> pageList) {
		return pageList.get(LEFT_PAGE) % 2 == 0 || pageList.get(RIGHT_PAGE) % 2 == 1;
	}

	private static boolean isNotContiguous(List<Integer> pageList) {
		return pageList.get(LEFT_PAGE) + 1 != pageList.get(RIGHT_PAGE);
	}

	private static boolean isInvalidRange(List<Integer> pageList) {
		return pageList.get(LEFT_PAGE) < MINIMUM_PAGE_NUMBER || pageList.get(RIGHT_PAGE) > MAXIMUM_PAGE_NUMBER;
	}

	private static int selectSide(List<Integer> pageList) {
		int left = selectOperation(pageList.get(LEFT_PAGE));
		int right = selectOperation(pageList.get(RIGHT_PAGE));

		return Math.max(left, right);
	}

	private static int selectOperation(int num) {
		int sum = 0;
		int multiple = 1;

		while (num != 0) {
			sum += num % 10;
			multiple *= num % 10;
			num /= 10;
		}
		return Math.max(sum, multiple);
	}
}