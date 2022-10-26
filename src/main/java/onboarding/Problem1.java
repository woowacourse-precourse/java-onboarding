package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {

	private static final int MIN_PAGE = 1;
	private static final int MAX_PAGE = 400;

	private static final int LEFT_PAGE_INDEX = 0;
	private static final int RIGHT_PAGE_INDEX = 1;

	private static final int EXCEPTION_CODE = -1;
	private static final int POBI_WIN_CODE = 1;
	private static final int CRONG_WIN_CODE = 2;
	private static final int DRAW_CODE = 0;

	public static int solution(List<Integer> pobi, List<Integer> crong) {
		int answer = Integer.MAX_VALUE;

		if (isValidPages(pobi) && isValidPages(crong)) {
			int pobiScore = getScore(pobi);
			int crongScore = getScore(crong);

			answer = getResultCode(pobiScore, crongScore);
		} else {
			answer = EXCEPTION_CODE;
		}

		return answer;
	}

	public static boolean isValidPages(List<Integer> pages) {
		Integer leftPage = pages.get(LEFT_PAGE_INDEX);
		Integer rightPage = pages.get(RIGHT_PAGE_INDEX);

		if ((isOutOfRange(leftPage) || isOutOfRange(rightPage))) {
			return false;
		}

		if (!isOdd(leftPage) || !isEven(rightPage)) {
			return false;
		}

		if (!isContinuousNumber(leftPage, rightPage)) {
			return false;
		}

		return true;
	}

	public static int getScore(List<Integer> pages) {
		Integer leftPage = pages.get(LEFT_PAGE_INDEX);
		Integer rightPage = pages.get(RIGHT_PAGE_INDEX);

		int maxNumberOfLeftPage = getMaxNumberByPage(leftPage);
		int maxNumberOfRightPage = getMaxNumberByPage(rightPage);

		if (maxNumberOfLeftPage > maxNumberOfRightPage) {
			return maxNumberOfLeftPage;
		}

		return maxNumberOfRightPage;
	}

	public static int getResultCode(final int pobiScore, final int crongScore) {
		int resultCode = 0;
		if (pobiScore > crongScore) {
			resultCode = POBI_WIN_CODE;
		} else if (pobiScore < crongScore) {
			resultCode = CRONG_WIN_CODE;
		} else {
			resultCode =  DRAW_CODE;
		}

		return resultCode;
	}

	private static boolean isOutOfRange(int page) {
		if (page < MIN_PAGE || page > MAX_PAGE) {
			return true;
		}

		return false;
	}

	private static boolean isOdd(int page) {
		return page % 2 == 1;
	}

	private static boolean isEven(int page) {
		return page % 2 == 0;
	}

	private static boolean isContinuousNumber(int a, int b) {
		return b - a == 1;
	}

	private static int getMaxNumberByPage(int page) {
		List<Integer> pageEach = separateInteger(page);

		int sum = getSum(pageEach);
		int multiples = getMultiples(pageEach);

		if (sum > multiples) {
			return sum;
		}

		return multiples;
	}

	private static List<Integer> separateInteger(int target) {
		List<Integer> separated = new ArrayList<>();

		while (target != 0) {
			int singleNumber = target % 10;
			separated.add(singleNumber);

			target /= 10;
		}

		return separated;
	}

	private static int getSum(List<Integer> integers) {
		return integers.stream()
			.mapToInt(i -> i)
			.sum();
	}

	private static int getMultiples(List<Integer> integers) {
		int result = 1;
		for (Integer integer : integers) {
			result *= integer;
		}

		return result;
	}

}