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

		return 0; //TODO - 임시값 변경하기
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
}