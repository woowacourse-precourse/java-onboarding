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
		return getResult(pobi, crong);
	}

	private static int getResult(List<Integer> pobi, List<Integer> crong) {
		if (isInvalidInput(pobi) || isInvalidInput(crong)) {
			return EXCEPTION;
		}
		if (getMaxValueFromPages(pobi) > getMaxValueFromPages(crong)) {
			return POBI_IS_WINNER;
		}
		if (getMaxValueFromPages(pobi) < getMaxValueFromPages(crong)) {
			return CRONG_IS_WINNER;
		}
		return DRAW;
	}

	private static boolean isInvalidInput(List<Integer> pages) {
		return isInvalidRange(pages) || isNotContiguous(pages) || isInvalidParity(pages);
	}

	private static boolean isInvalidParity(List<Integer> pages) {
		return pages.get(LEFT_PAGE) % 2 == 0 || pages.get(RIGHT_PAGE) % 2 == 1;
	}

	private static boolean isNotContiguous(List<Integer> pages) {
		return pages.get(LEFT_PAGE) + 1 != pages.get(RIGHT_PAGE);
	}

	private static boolean isInvalidRange(List<Integer> pages) {
		return pages.get(LEFT_PAGE) < MINIMUM_PAGE_NUMBER || pages.get(RIGHT_PAGE) > MAXIMUM_PAGE_NUMBER;
	}

	private static int getMaxValueFromPages(List<Integer> pages) {
		int left = getMaxValueFromPage(pages.get(LEFT_PAGE));
		int right = getMaxValueFromPage(pages.get(RIGHT_PAGE));
		return Math.max(left, right);
	}

	private static int getMaxValueFromPage(int page) {
		int sum = 0;
		int multiple = 1;
		while (page != 0) {
			sum += page % 10;
			multiple *= page % 10;
			page /= 10;
		}
		return Math.max(sum, multiple);
	}
}