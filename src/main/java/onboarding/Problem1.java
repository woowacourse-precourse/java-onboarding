package onboarding;

import java.util.List;

class Problem1 {

	public static final int HUNDRED = 100;
	public static final int SUM_START = 0;
	public static final int MULTIPLY_START = 1;
	public static final int LEFT_PAGE = 0;
	public static final int RIGHT_PAGE = 1;
	public static final int NORMAL_PAGE_SIZE = 2;
	public static final int TEN = 10;
	public static final int EXCEPTION = -1;
	public static final int POBI_WIN = 1;
	public static final int CRONG_WIN = 2;
	public static final int DRAW = 0;
	public static final int FIRST_PAGE = 1;
	public static final int LAST_PAGE = 400;
	public static final int PAGE_DIFFERENCE = 1;

	public static int solution(List<Integer> pobi, List<Integer> crong) {

		if (validateBook(pobi, crong)) {
			return EXCEPTION;
		}

		int pobiMaxNumber = getMaxNumber(pobi);
		int crongMaxNumber = getMaxNumber(crong);

		if (pobiMaxNumber > crongMaxNumber) {
			return POBI_WIN;
		}

		if (pobiMaxNumber < crongMaxNumber) {
			return CRONG_WIN;
		}

		return DRAW;
	}

	private static boolean validateBook(List<Integer> pobi, List<Integer> crong) {
		return !(isRightBook(pobi) && isRightBook(crong));
	}

	private static boolean isRightBook(List<Integer> book) {
		return isRightSize(book) && isRightOrder(book);
	}

	private static boolean isRightSize(List<Integer> book) {
		return book.size() == NORMAL_PAGE_SIZE &&
				FIRST_PAGE <= leftPage(book) &&
				rightPage(book) <= LAST_PAGE;
	}

	private static boolean isRightOrder(List<Integer> book) {
		return isLeftPageOdd(book) &&
				rightPageEven(book) &&
				isRightSizeOfBook(book);
	}

	private static Integer leftPage(List<Integer> book) {
		return book.get(LEFT_PAGE);
	}

	private static Integer rightPage(List<Integer> book) {
		return book.get(RIGHT_PAGE);
	}

	private static boolean isLeftPageOdd(List<Integer> book) {
		return leftPage(book) % 2 == 1;
	}

	private static boolean rightPageEven(List<Integer> book) {
		return rightPage(book) % 2 == 0;
	}

	private static boolean isRightSizeOfBook(List<Integer> book) {
		return rightPage(book) - leftPage(book) == PAGE_DIFFERENCE;
	}

	private static int getMaxNumber(List<Integer> book) {
		int leftPageMax = getMaxValue(leftPage(book));
		int rightPageMax = getMaxValue(rightPage(book));

		return Math.max(leftPageMax, rightPageMax);
	}

	private static int getMaxValue(Integer page) {
		int sum = SUM_START;
		int multiply = MULTIPLY_START;

		if (page >= HUNDRED) {
			int hundredDigit = page / HUNDRED;
			sum += hundredDigit;
			multiply *= hundredDigit;
			page -= hundredDigit * HUNDRED;
		}

		if (page >= TEN) {
			int tenDigit = page / TEN;
			sum += tenDigit;
			multiply *= tenDigit;
			page -= tenDigit * TEN;
		}

		int oneDigit = page;
		sum += oneDigit;
		multiply *= oneDigit;

		return Math.max(sum, multiply);
	}
}