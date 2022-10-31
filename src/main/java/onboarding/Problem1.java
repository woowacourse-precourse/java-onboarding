package onboarding;

import java.util.Arrays;
import java.util.List;

class Problem1 {
	private static final int MIN_PAGE = 1;
	private static final int MAX_PAGE = 400;
	private static final int LEFT_PAGE = 0;
	private static final int RIGHT_PAGE = 1;
	private static final int WIN_POBI = 1;
	private static final int WIN_CRONG = 2;
	private static final int DRAW = 0;
	private static final int NOT_PAGE_NUMBER = -1;

	public static int solution(List<Integer> pobi, List<Integer> crong) {
		int pobiLeftPage = pobi.get(LEFT_PAGE);
		int pobiRightPage = pobi.get(RIGHT_PAGE);
		int crongLeftPage = crong.get(LEFT_PAGE);
		int crongRightPage = crong.get(RIGHT_PAGE);

		if (!(checkPageForm(pobiLeftPage, pobiRightPage)
			&& checkPageForm(crongLeftPage, crongRightPage))) {
			return NOT_PAGE_NUMBER;
		}
		int pobiMax = pageMax(pobiLeftPage, pobiRightPage);
		int crongMax = pageMax(crongLeftPage, crongRightPage);
		return gameResult(pobiMax, crongMax);
	}

	private static boolean checkPageForm(int leftPage, int rightPage) {
		return checkBetweenPage(leftPage, rightPage)
			&& checkLeftOddRightEven(leftPage, rightPage)
			&& checkDifferenceOnePage(leftPage, rightPage);
	}

	private static boolean checkBetweenPage(int leftPage, int rightPage) {
		return (leftPage > MIN_PAGE) && (rightPage < MAX_PAGE);
	}

	private static boolean checkLeftOddRightEven(int leftPage, int rightPage) {
		return (leftPage % 2 == 1) && (rightPage % 2 == 0);
	}

	private static boolean checkDifferenceOnePage(int leftPage, int rightPage) {
		return rightPage - leftPage == 1;
	}

	private static int pageMax(int leftPage, int rightPage) {
		int leftMaxValue = Math.max(addDigit(leftPage),
			multipleDigit(rightPage));
		int rightMaxValue = Math.max(addDigit(rightPage),
			multipleDigit(leftPage));
		return Math.max(leftMaxValue, rightMaxValue);
	}

	private static int addDigit(Integer page) {
		return Arrays.stream(String.valueOf(page).split(""))
			.mapToInt(Integer::parseInt)
			.sum();
	}

	private static int multipleDigit(Integer page) {
		return Arrays.stream(String.valueOf(page).split(""))
			.mapToInt(Integer::parseInt)
			.reduce(1, (a, b) -> a * b);
	}

	private static int gameResult(int pobiScore, int crongScore) {
		if (pobiScore > crongScore) {
			return WIN_POBI;
		} else if (pobiScore < crongScore) {
			return WIN_CRONG;
		} else {
			return DRAW;
		}
	}
}
