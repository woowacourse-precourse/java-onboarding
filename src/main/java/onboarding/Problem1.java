package onboarding;

import java.util.List;

class Problem1 {
	public static int solution(List<Integer> pobi, List<Integer> crong) {
		int answer = Integer.MAX_VALUE;
		if (maxPageScore(pobi) > maxPageScore(crong)) {
			answer = 1;
		} else if (maxPageScore(pobi) == maxPageScore(crong)) {
			answer = 0;
		} else if (maxPageScore(pobi) < maxPageScore(crong)) {
			answer = 2;
		}
		if (!exception(pobi) || !exception(crong)) {
			answer = -1;
		}
		return answer;
	}
	
	private static int maxPageScore(List<Integer> person) {
		int leftPage = person.get(0);
		int rightPage = person.get(1);
		int maxLeftPageScore = Math.max(sumEachPage(leftPage), multipleEachPage(rightPage));
		int maxRightPageScore = Math.max(sumEachPage(rightPage), multipleEachPage(rightPage));

		return Math.max(maxLeftPageScore, maxRightPageScore);
	}

	private static int sumEachPage(int page) {
		int sumPage = 0;
		while (page > 0) {
			sumPage += page % 10;
			page /= 10;
		}
		return sumPage;
	}

	private static int multipleEachPage(int page) {
		int multiplePage = 1;
		while (page > 1) {
			multiplePage *= (page % 10);
			page /= 10;
		}
		return multiplePage;
	}

	private static boolean exception(List<Integer> person) {
		int leftPage = person.get(0);
		int rightPage = person.get(1);

		if (rightPage - leftPage != 1) {
			return false;
		} else if (rightPage < 1 || leftPage < 1) {
			return false;
		}
		return true;
	}

}