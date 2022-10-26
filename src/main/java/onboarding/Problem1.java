package onboarding;

import java.util.List;

class Problem1 {
	private static final int NUMBER_OF_DIGIT_DIVISION = 10;
	private static final int MIN_PAGE = 1;
	private static final int MAX_PAGE = 400;
	private static final int LEFT_PAGE = 0;
	private static final int RIGHT_PAGE = 1;
	private static final int WIN_POBI = 1;
	private static final int WIN_CRONG = 2;
	private static final int DRAW = 0;
	private static final int NOT_PAGE_NUMBER = -1;

	public static int solution(List<Integer> pobi, List<Integer> crong) {
		int answer;
		if (!checkPageForm(pobi, crong)) {
			return NOT_PAGE_NUMBER;
		}
		int pobiMax = pageMax(pobi);
		int crongMax = pageMax(crong);

		if(pobiMax > crongMax) {
			answer = WIN_POBI;
		} else if (pobiMax < crongMax) {
			answer = WIN_CRONG;
		} else {
			answer = DRAW;
		}
		return answer;
	}

	private static boolean checkPageForm(List<Integer> pobi, List<Integer> crong) {
		if (pobi.get(LEFT_PAGE) < MIN_PAGE || pobi.get(RIGHT_PAGE) > MAX_PAGE
				|| crong.get(LEFT_PAGE) < MIN_PAGE || crong.get(RIGHT_PAGE) > MAX_PAGE) {
			return false;
		}
		if ((pobi.get(LEFT_PAGE) - pobi.get(RIGHT_PAGE)) != 1 || (crong.get(LEFT_PAGE) - crong.get(RIGHT_PAGE)) !=1){
			return false;
		}
		return true;
	}

	private static int addDigit(Integer page) {
		int addValue = 0;
		while (page != 0) {
			addValue += page % NUMBER_OF_DIGIT_DIVISION;
			page /= NUMBER_OF_DIGIT_DIVISION;
		}
		return addValue;
	}

	private static int multipleDigit(Integer page) {
		int multipleValue = 1;
		while (page != 0) {
			multipleValue *= page % NUMBER_OF_DIGIT_DIVISION;
			page /= NUMBER_OF_DIGIT_DIVISION;
		}
		return multipleValue;
	}

	private static int pageMax(List<Integer> pages) {
		int leftMaxValue = Math.max(addDigit(pages.get(LEFT_PAGE)),
				multipleDigit(pages.get(LEFT_PAGE)));
		int rightMaxValue = Math.max(addDigit(pages.get(RIGHT_PAGE)),
				multipleDigit(pages.get(RIGHT_PAGE)));
		return Math.max(leftMaxValue, rightMaxValue);
	}


}
