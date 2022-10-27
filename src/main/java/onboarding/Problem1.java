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
		return false;
	}

	public static boolean isNotInRange(List<Integer> pages) {
		int leftPageNum = pages.get(0);
		int rightPageNum = pages.get(1);
		return leftPageNum < 1 || leftPageNum > 400 || rightPageNum < 1 || rightPageNum > 400;
	}

	public static boolean isPageNumNotEven(int page) {

		return false;
	}

	public static boolean isPageNumNotOdd(int page) {
		return false;
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
