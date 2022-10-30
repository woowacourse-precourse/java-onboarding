package onboarding;

import java.util.List;

class Problem1 {
	public static int solution(List<Integer> pobi, List<Integer> crong) {
		int answer = Integer.MAX_VALUE;
		return answer;
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