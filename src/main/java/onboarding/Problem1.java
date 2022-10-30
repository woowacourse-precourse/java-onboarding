package onboarding;

import java.util.List;

class Problem1 {
	private static final int POBIWIN = 1;
	private static final int CRONGWIN = 2;
	private static final int DRAW = 0;
	private static final int EXCEPTIONCODE = -1;

	public static int solution(List<Integer> pobi, List<Integer> crong) {

		Page pobiPage = new Page(pobi.get(0), pobi.get(1));
		Page crongPage = new Page(crong.get(0), crong.get(1));

		if (!pobiPage.isValid() || !crongPage.isValid()) {
			return EXCEPTIONCODE;
		}

		int pobiScore = getScore(pobiPage);
		int crongScore = getScore(crongPage);

		return findWinner(pobiScore, crongScore);
	}

	private static int findWinner(int pobiScore, int crongScore) {
		if (pobiScore > crongScore) {
			return POBIWIN;
		}

		if (pobiScore < crongScore) {
			return CRONGWIN;
		}

		if (pobiScore == crongScore) {
			return DRAW;
		}

		return EXCEPTIONCODE;
	}

	private static int getScore(Page page) {
		int left = page.getLeft();
		int right = page.getRight();

		return Math.max(pageNumberToScore(left), pageNumberToScore(right));
	}

	private static int pageNumberToScore(int pageNumber) {
		int sumScore = 0;
		int multipleScore = 1;

		while (pageNumber > 0) {
			sumScore += pageNumber % 10;
			multipleScore *= pageNumber % 10;

			pageNumber /= 10;
		}

		return Math.max(sumScore, multipleScore);
	}
}