package onboarding;

import java.util.List;

class Problem1 {

	public static int solution(List<Integer> pobi, List<Integer> crong) {
		int answer = Integer.MAX_VALUE;
		if (isInvalid(pobi, crong)) {
			return -1;
		}
		return answer;
	}

	public static boolean isInvalid(List<Integer> pobi, List<Integer> crong) {
		if (isNotInRange(pobi) || isNotInRange(crong)) {
			return true;
		}
		int pobiLeftPageNum = pobi.get(0);
		int pobiRightPageNum = pobi.get(1);
		int crongLeftPageNum = crong.get(0);
		int crongRightPageNum = crong.get(1);
		if (isPageNumNotEven(pobiLeftPageNum) || isPageNumNotEven(crongLeftPageNum) ||
			isPageNumNotOdd(pobiRightPageNum) || isPageNumNotOdd(crongRightPageNum)) {
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
		return false;
	}

	public static int calculateScore(List<Integer> pages) {
		return 0;
	}

	public static int pageScoreAdd(int page) {
		return 0;
	}

	public static int pageScoreMult(int page) {
		return 0;
	}

	public static int findGreaterScore(int scoreAdd, int scoreMult) {
		return 0;
	}

	public static int winnerCheck(int pobiScore, int crongScore) {

		return 2;
	}
}
