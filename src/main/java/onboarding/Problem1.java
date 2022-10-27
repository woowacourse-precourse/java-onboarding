package onboarding;

import java.util.List;

class Problem1 {

	public static int solution(List<Integer> pobi, List<Integer> crong) {
		if (isInvalid(pobi, crong)) {
			return -1;
		}
		int pobiScore = calculateScore(pobi);
		int crongScore = calculateScore(crong);
		return winnerCheck(pobiScore, crongScore);
	}

	public static boolean isInvalid(List<Integer> pobi, List<Integer> crong) {
		if (isNotInRange(pobi) || isNotInRange(crong)) {
			return true;
		}
		int pobiLeftPageNum = pobi.get(0);
		int pobiRightPageNum = pobi.get(1);
		int crongLeftPageNum = crong.get(0);
		int crongRightPageNum = crong.get(1);
		if (isPageNumNotOdd(pobiLeftPageNum) || isPageNumNotOdd(crongLeftPageNum) ||
			isPageNumNotEven(pobiRightPageNum) || isPageNumNotEven(crongRightPageNum)) {
			return true;
		}
		if (isInvalidPage(pobiLeftPageNum, pobiRightPageNum) || isInvalidPage(crongLeftPageNum, crongRightPageNum)) {
			return true;
		}
		return false;
	}

	public static boolean isNotInRange(List<Integer> pages) {
		int leftPageNum = pages.get(0);
		int rightPageNum = pages.get(1);
		return leftPageNum < 1 || leftPageNum > 400 || rightPageNum < 1 || rightPageNum > 400;
	}

	public static boolean isPageNumNotEven(int page) {
		return page % 2 != 0;
	}

	public static boolean isPageNumNotOdd(int page) {
		return page % 2 == 0;
	}

	public static boolean isInvalidPage(int leftPageNum, int rightPageNum) {
		return leftPageNum + 1 != rightPageNum;
	}

	public static int calculateScore(List<Integer> pages) {
		int leftPageNum = pages.get(0);
		int rightPageNum = pages.get(1);
		int leftPageScore = findGreaterScore(pageScoreAdd(leftPageNum), pageScoreMult(leftPageNum));
		int rightPageScore = findGreaterScore(pageScoreAdd(rightPageNum), pageScoreMult(rightPageNum));
		return Math.max(leftPageScore, rightPageScore);
	}

	public static int pageScoreAdd(int page) {
		int total = 0;
		while (page > 0) {
			total += page % 10;
			page /= 10;
		}
		return total;
	}

	public static int pageScoreMult(int page) {
		int total = 1;
		while (page > 0) {
			total *= page % 10;
			page /= 10;
		}
		return total;
	}

	public static int findGreaterScore(int scoreAdd, int scoreMult) {
		return Math.max(scoreAdd, scoreMult);
	}

	public static int winnerCheck(int pobiScore, int crongScore) {
		if (pobiScore > crongScore) {
			return 1;
		}
		if (pobiScore < crongScore) {
			return 2;
		}
		return 0;
	}
}
