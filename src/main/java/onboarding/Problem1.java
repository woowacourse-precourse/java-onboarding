package onboarding;

import java.util.List;

class Problem1 {

	public static final int DRAW = 0;
	public static final int POBI_WON = 1;
	public static final int CRONG_WON = 2;

	public static int solution(List<Integer> pobi, List<Integer> crong) {
		int answer = Integer.MAX_VALUE;

		if (checkRestrictions(pobi) == -1 || checkRestrictions(crong) == -1) {
			return -1;
		}

		int pobiScore = calcPageNumberScore(pobi);
		int crongScore = calcPageNumberScore(crong);

		answer = compareScores(pobiScore, crongScore);

		return answer;
	}

	private static int compareScores(int pobiScore, int crongScore) {
		int answer = -1;
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
			return -1;
		}
		if (!isPagesRangeValid(pages)) {
			return -1;
		}
		if (!isPagesContiguousValid(pages)) {
			return -1;
		}
		if (!isPagesEvenOddValid(pages)) {
			return -1;
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
		Integer leftPage = pages.get(0);
		Integer rightPage = pages.get(1);
		if (rightPage - leftPage != 1) {
			return false;
		}
		return true;
	}

	private static boolean isPagesEvenOddValid(List<Integer> pages) {
		Integer leftPage = pages.get(0);
		Integer rightPage = pages.get(1);
		if (leftPage % 2 != 1 || rightPage % 2 != 0) {
			return false;
		}
		return true;
	}

	private static boolean isPagesRangeValid(List<Integer> pages) {
		Integer leftPage = pages.get(0);
		Integer rightPage = pages.get(1);
		if (leftPage < 1 || rightPage > 400) {
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
