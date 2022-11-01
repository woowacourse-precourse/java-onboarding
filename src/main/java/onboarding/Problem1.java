package onboarding;

import java.util.List;

class Problem1 {

	public static final int DRAW = 0;
	public static final int POBI_WON = 1;
	public static final int CRONG_WON = 2;

	public static final int LEFT_PAGE = 0;
	public static final int RIGHT_PAGE = 1;

	public static final int FIRST_PAGE = 1;
	public static final int LAST_PAGE = 400;

	public static final int EXCEPTION = -1;

	public static int solution(List<Integer> pobi, List<Integer> crong) {
		int answer = Integer.MAX_VALUE;

		if (checkRestrictions(pobi) == EXCEPTION || checkRestrictions(crong) == EXCEPTION) {
			return EXCEPTION;
		}

		int pobiScore = calcPageNumberScore(pobi);
		int crongScore = calcPageNumberScore(crong);

		answer = compareScores(pobiScore, crongScore);

		return answer;
	}

	private static int compareScores(int pobiScore, int crongScore) {
		int answer = EXCEPTION;
		if (pobiScore == crongScore) {
			answer = DRAW;
		}
		if (pobiScore > crongScore) {
			answer = POBI_WON;
		}
		if (pobiScore < crongScore) {
			answer = CRONG_WON;
		}
		return answer;
	}

	private static Integer checkRestrictions(List<Integer> pages) {
		if (!isPagesSizeValid(pages)) {
			return EXCEPTION;
		}
		if (!isPagesRangeValid(pages)) {
			return EXCEPTION;
		}
		if (!isPagesContiguousValid(pages)) {
			return EXCEPTION;
		}
		if (!isPagesEvenOddValid(pages)) {
			return EXCEPTION;
		}
		return 0;
	}

	private static boolean isPagesSizeValid(List<Integer> pages) {
		if (pages.size() != 2) {
			return false;
		}
		return true;
	}

	private static boolean isPagesContiguousValid(List<Integer> pages) {
		Integer leftPage = pages.get(LEFT_PAGE);
		Integer rightPage = pages.get(RIGHT_PAGE);
		if (rightPage - leftPage != 1) {
			return false;
		}
		return true;
	}

	private static boolean isPagesEvenOddValid(List<Integer> pages) {
		Integer leftPage = pages.get(LEFT_PAGE);
		Integer rightPage = pages.get(RIGHT_PAGE);
		if (leftPage % 2 != 1 || rightPage % 2 != 0) {
			return false;
		}
		return true;
	}

	private static boolean isPagesRangeValid(List<Integer> pages) {
		Integer leftPage = pages.get(LEFT_PAGE);
		Integer rightPage = pages.get(RIGHT_PAGE);
		if (leftPage < FIRST_PAGE || rightPage > LAST_PAGE) {
			return false;
		}
		return true;
	}

	private static int calcPageNumberScore(List<Integer> pages) {
		int pageSum = 0;
		int pageMultiplication = 1;
		int greater = 0;
		int score = -1;
		int singleDigit = 0;

		for (Integer page : pages) {
			while (page > 0) {
				singleDigit = page % 10;
				pageSum += singleDigit;
				pageMultiplication *= singleDigit;
				greater = Math.max(pageSum, pageMultiplication);
				page /= 10;
			}
			if (greater > score) {
				score = greater;
			}
		}
		return score;
	}
}
