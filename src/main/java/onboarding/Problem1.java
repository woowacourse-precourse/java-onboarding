package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }

	private static boolean isValidPage(List<Integer> pages) {
		int leftPage = pages.get(0);
		int rightPage = pages.get(1);

		if (leftPage >= rightPage)
			return false;
		if (leftPage < 1 || leftPage > 400)
			return false;
		if (rightPage > 400)
			return false;
		if (rightPage - leftPage != 1)
			return false;
		if (leftPage % 2 != 1)
			return false;
		if (rightPage % 2 != 0)
			return false;

		return true;
	}

	private static int calculatorScore(int page) {
		int sumScore = 0;
		int mulScore = 1;

		int[] numOfDigitList = Stream.of(String.valueOf(page).split("")).mapToInt(Integer::parseInt).toArray();

		for (int num : numOfDigitList) {
			sumScore += num;
			mulScore *= num;
		}

		return Math.max(sumScore, mulScore);
	}