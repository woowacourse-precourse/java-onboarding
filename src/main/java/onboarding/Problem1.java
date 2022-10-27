package onboarding;

import java.util.List;

class Problem1 {

	public static final int HUNDRED = 100;
	public static final int SUM_START = 0;
    public static final int MULTIPLY_START = 1;
	public static final int LEFT_PAGE = 0;
	public static final int RIGHT_PAGE = 1;
	public static final int TEN = 10;

    public static int solution(List<Integer> pobi, List<Integer> crong) {

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

	private static int getMaxNumber(List<Integer> book) {
		int leftPageMax = getMaxValue(book.get(LEFT_PAGE));
		int rightPageMax = getMaxValue(book.get(RIGHT_PAGE));

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