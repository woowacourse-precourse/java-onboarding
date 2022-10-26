package onboarding;

import java.util.List;

class Problem1 {
	public static final int FIRST_PAGE = 1;
	public static final int LAST_PAGE = 400;
    static class PageCalculator {
		int leftPage;
		int rightPage;

		public PageCalculator(int leftPage, int rightPage) {
			this.leftPage = leftPage;
			this.rightPage = rightPage;
		}

		public int calculatePlus(int pageNumber) {
			int sumResult = 0;
			while (pageNumber != 0) {
				sumResult += pageNumber % 10;
				pageNumber /= 10;
			}
			return sumResult;
		}

		public int calculateMultiply(int pageNumber) {
			int multipleResult = 1;
			while (pageNumber != 0) {
				multipleResult *= pageNumber % 10;
				pageNumber /= 10;
			}
			return multipleResult;
		}

		public int calculateMax(int pageNumber) {

			return Math.max(calculatePlus(pageNumber), calculateMultiply(pageNumber));
		}

		public int returnResult() {

			return Math.max(calculateMax(leftPage), calculateMax(rightPage));
		}
	}

	public static int checkPageRange(int leftPage, int rightPage) {
		if (rightPage - leftPage != 1) {
			return -1;
		}
		if (leftPage == FIRST_PAGE) {
			return -1;
		}
		if (rightPage == LAST_PAGE) {
			return -1;
		}
		return 1;
	}

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }
}
