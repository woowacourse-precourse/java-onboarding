package onboarding;

import java.util.List;

class Problem1 {
	private static final int ODD = 1;
	private static final int EVEN = 0;
	private static final int FIRST_ELEMENT = 0;
	private static final int SECOND_ELEMENT = 1;
	private static final int POBI_WIN = 1;
	private static final int CRONG_WIN = 2;
	private static final int DRAW = 0;
	private static final int ERROR = -1;
	private static final boolean FAIL = false;
	private static final boolean SUCCESS = true;
	private static final int MAX_NUMBER = 400;
	private static final int MIN_NUMBER = 1;
	private static final int INTERVAL = 1;

	public static int solution(List<Integer> pobi, List<Integer> crong) {
		if (!validate(pobi, crong)) {
			return ERROR;
		}

		int pobiMaxScore = calculateMaxScoreBetweenPages(pobi.get(FIRST_ELEMENT), pobi.get(SECOND_ELEMENT));
		int crongMaxScore = calculateMaxScoreBetweenPages(crong.get(FIRST_ELEMENT), crong.get(SECOND_ELEMENT));

		return getWinner(pobiMaxScore, crongMaxScore);
	}

	private static boolean validate(List<Integer> pobi, List<Integer> crong) {
		int pobiFirstPage = pobi.get(FIRST_ELEMENT);
		int pobiSecondPage = pobi.get(SECOND_ELEMENT);
		int crongFirstPage = crong.get(FIRST_ELEMENT);
		int crongSecondPage = crong.get(SECOND_ELEMENT);

		if (!isRightRange(pobiFirstPage, pobiSecondPage) || !isRightRange(crongFirstPage, crongSecondPage)) {
			return FAIL;
		}

		if (!isOdd(pobiFirstPage) || !isEven(pobiSecondPage) || !isOdd(crongFirstPage) || !isEven(crongSecondPage)) {
			return FAIL;
		}

		if (!isRightInterval(pobiFirstPage, pobiSecondPage) || !isRightInterval(crongFirstPage, crongSecondPage)) {
			return FAIL;
		}

		return SUCCESS;
	}

	private static boolean isRightRange(int firstPage, int secondPage) {
		return firstPage >= MIN_NUMBER && firstPage < MAX_NUMBER && secondPage > MIN_NUMBER && secondPage <= MAX_NUMBER;
	}

	private static boolean isOdd(int number) {
		return number % 2 == ODD;
	}

	private static boolean isEven(int number) {
		return number % 2 == EVEN;
	}

	private static boolean isRightInterval(int firstPage, int secondPage) {
		return secondPage - firstPage == INTERVAL;
	}

	private static int calculateMaxScoreBetweenPages(int firstPage, int secondPage) {
		int firstPageMaxScore = calculateMaxScoreBetweenOperations(firstPage);
		int secondPageMaxScore = calculateMaxScoreBetweenOperations(secondPage);

		return Math.max(firstPageMaxScore, secondPageMaxScore);
	}

	private static int calculateMaxScoreBetweenOperations(int page) {
		int addDigits = addDigits(page);
		int multiplyDigits = multiplyDigits(page);

		return Math.max(addDigits, multiplyDigits);
	}

	private static int multiplyDigits(int page) {
		char[] digits = String.valueOf(page).toCharArray();
		int result = 1;

		for (char digit : digits) {
			result *= Character.getNumericValue(digit);
		}

		return result;
	}

	private static int addDigits(int page) {
		char[] digits = String.valueOf(page).toCharArray();
		int result = 0;

		for (char digit : digits) {
			result += Character.getNumericValue(digit);
		}

		return result;
	}

	private static int getWinner(int pobiMaxScore, int crongMaxScore) {
		if (isPobiWin(pobiMaxScore, crongMaxScore)) {
			return POBI_WIN;
		} else if (isCrongWin(pobiMaxScore, crongMaxScore)) {
			return CRONG_WIN;
		} else {
			return DRAW;
		}
	}

	private static boolean isPobiWin(int pobiMaxScore, int crongMaxScore) {
		return pobiMaxScore > crongMaxScore;
	}

	private static boolean isCrongWin(int pobiMaxScore, int crongMaxScore) {
		return pobiMaxScore < crongMaxScore;
	}
}