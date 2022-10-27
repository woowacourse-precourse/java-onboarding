package onboarding;

import java.util.List;

class Problem1 {

	public static final int HUNDRED = 100;
	public static final int SUM_START = 0;
	public static final int MULTIPLY_START = 1;
	public static final int LEFT_PAGE = 0;
	public static final int RIGHT_PAGE = 1;
	public static final int NORMAL_BOOK_SIZE = 2;
	public static final int TEN = 10;

	public static int solution(List<Integer> pobi, List<Integer> crong) {

		if (!checkBook(pobi, crong)) {
			return -1;
		}

		int pobiMaxNumber = getMaxNumber(pobi);
		int crongMaxNumber = getMaxNumber(crong);

		if (pobiMaxNumber > crongMaxNumber) {
			return 1;
		}

		if (pobiMaxNumber < crongMaxNumber) {
			return 2;
		}

		return 0;
	}

	private static boolean checkBook(List<Integer> pobi, List<Integer> crong) {
		return isRightBook(pobi) && isRightBook(crong);
	}

	private static boolean isRightBook(List<Integer> book) {
		return isRightSize(book) && isRightOrder(book);
	}

	private static boolean isRightSize(List<Integer> book) {
		return book.size() == NORMAL_BOOK_SIZE &&
				0 <= leftPage(book) &&
				rightPage(book) <= 400;
	}

	private static Integer rightPage(List<Integer> book) {
		return book.get(RIGHT_PAGE);
	}

	private static Integer leftPage(List<Integer> book) {
		return book.get(LEFT_PAGE);
	}

	private static boolean isRightOrder(List<Integer> book) {
		return leftPage(book) < rightPage(book) &&
				leftPage(book) % 2 == 1 &&
				rightPage(book) % 2 == 0;
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