package onboarding;

import java.util.List;

class Problem1 {
	public static int solution(List<Integer> pobi, List<Integer> crong) {
		int answer = judgeWinner(pobi, crong);
		return answer;
	}

	private static int judgeWinner(List<Integer> firstPerson, List<Integer> secondPerson) {
		final int FIRST_PERSON_WIN = 1;
		final int SECOND_PERSON_WIN = 2;
		final int DRAW = 0;
		final int EXCEPTION = -1;
		int firstPersonScore = maxPageScore(firstPerson);
		int secondPersonScore = maxPageScore(secondPerson);

		if (exceptionOccur(firstPerson) || exceptionOccur(secondPerson)) {
			return EXCEPTION;
		} else if (firstPersonScore > secondPersonScore) {
			return FIRST_PERSON_WIN;
		} else if (firstPersonScore == secondPersonScore) {
			return DRAW;
		} else {
			return SECOND_PERSON_WIN;
		}
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

	private static boolean exceptionOccur(List<Integer> person) {
		int leftPage = person.get(0);
		int rightPage = person.get(1);

		if (rightPage - leftPage != 1) {
			return true;
		} else if (leftPage % 2 != 1 || rightPage % 2 != 0) {
			return true;
		} else if (leftPage == 1 || rightPage == 400) {
			return true;
		} else if (leftPage < 1 || rightPage > 400) {
			return true;
		}
		return false;
	}

}
