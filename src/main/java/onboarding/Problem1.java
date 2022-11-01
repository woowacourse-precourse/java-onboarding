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

	/**
	 * 점수를 비교해 알맞은 값을 리턴하는 메서드
	 * @param pobiScore
	 * @param crongScore
	 * @return
	 */
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

	/**
	 * 제한사항을 위배했는지 체크하는 메서드
	 * @param pages
	 * @return
	 */
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
		return -0;
	}

	// 페이지 리스트의 요소가 2개가 아닌 경우 예외
	private static boolean isPagesSizeValid(List<Integer> pages) {
		if (pages.size() != 2) {
			return false;
		}
		return true;
	}

	// 페이지 리스트의 요소가 연속된 수가 아닌 경우 예외
	private static boolean isPagesContiguousValid(List<Integer> pages) {
		Integer leftPage = pages.get(0);
		Integer rightPage = pages.get(1);
		if (rightPage - leftPage != 1) {
			return false;
		}
		return true;
	}

	// 왼쪽 페이지가 홀수이고, 오른쪽 페이지가 짝수가 아닌 경우 예외
	private static boolean isPagesEvenOddValid(List<Integer> pages) {
		Integer leftPage = pages.get(0);
		Integer rightPage = pages.get(1);
		if (leftPage % 2 != 1 || rightPage % 2 != 0) {
			return false;
		}
		return true;
	}

	// 페이지 범위가 1 ~ 400 이 아닌 경우 예외
	private static boolean isPagesRangeValid(List<Integer> pages) {
		Integer leftPage = pages.get(0);
		Integer rightPage = pages.get(1);
		if (leftPage < 1 || rightPage > 400) {
			return false;
		}
		return true;
	}

	/**
	 * 한자리씩 쪼갠 숫자의 합과 곱을 계산하여 score 의 최댓값 갱신
	 * @param pages
	 * @return
	 */
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
