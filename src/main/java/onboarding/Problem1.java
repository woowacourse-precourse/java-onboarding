package onboarding;

import java.util.List;

class Problem1 {
	public static int solution(List<Integer> pobi, List<Integer> crong) {
		if (isNotValidPages(pobi) || isNotValidPages(crong)) {
			return -1;
		}
		int pobiMaxScore = getPagesMaxScore(pobi);
		int crongMaxScore = getPagesMaxScore(crong);
		int answer = -1;

		if (pobiMaxScore == crongMaxScore) {
			answer = 0;
		} else if (pobiMaxScore > crongMaxScore) {
			answer = 1;
		} else if (pobiMaxScore < crongMaxScore) {
			answer = 2;
		}
		return answer;
	}

	private static int getPagesMaxScore(List<Integer> pages) {
		int leftPageScore = findPageMaxScore(pages.get(0));
		int rightPageScore = findPageMaxScore(pages.get(1));
		return Math.max(leftPageScore, rightPageScore);
	}

	private static int findPageMaxScore(int page) {
		int sumResult = 0;
		int mulResult = 1;
		while (page > 0) {
			sumResult += page % 10;
			mulResult *= page % 10;
			page /= 10;
		}
		return Math.max(sumResult, mulResult);
	}

	private static boolean isNotValidPages(List<Integer> pages) {
		// 주어진 페이지가 Null 이거나, 주어진 페이지의 크기가 2장이 아닐 때 유효하지 않다.
		if (pages == null || pages.size() != 2) {
			return true;
		}
		// 왼쪽 페이지가 짝수거나, 오른쪽 페이지가 홀수인경우 유효하지 않다.
		if (pages.get(0) % 2 == 0 || pages.get(1) % 2 == 1) {
			return true;
		}
		// 오른쪽 페이지와 왼쪽 페이지를 뺏을 때 크기의 차이가 1보다 큰 경우 유효하지 않다.
		if (pages.get(1) - pages.get(0) != 1) {
			return true;
		}
		return false;
	}
}