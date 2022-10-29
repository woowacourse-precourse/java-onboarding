package onboarding;

import java.util.List;

class Problem1 {
	public static final int ERROR_CODE = -1;

	public static int solution(List<Integer> pobi, List<Integer> crong) {
		int answer = Integer.MAX_VALUE;

		if (isValidCondition(pobi) || isValidCondition(crong))
			return ERROR_CODE;

		if (isValidPages(pobi) || isValidPages(crong))
			return ERROR_CODE;

		return answer;
	}

	/**
	 * 1. 제한사항 체크
	 */
	public static boolean isValidCondition(List<Integer> pages) {
		if (pages.size() != 2)            // 리스트의 길이가 2 이상인 경우
			return true;
		if (pages.get(0) >= pages.get(1)) //왼쪽 오른쪽 페이지 순서로 있지 않은 경우
			return true;
		return false;
	}

	/**
	 * 2. 책에서 가능한 페이지 조합 확인
	 */
	public static boolean isValidPages(List<Integer> pages) {
		if (pages.get(1) - pages.get(0) != 1 || pages.get(0) % 2 == 0 || pages.get(1) % 2 == 1)
			// 왼쪽 오른쪽 페이지의 차가 1이 아닌 경우, 왼쪽페이지가 짝수인 경우, 오른쪽 페이지가 홀수인 경우
			return true;
		if (isFirstPage(pages) || isLastPage(pages)) {
			// 펏번째, 마지막 페이지인 경우
			return true;
		}
		if (pages.stream().anyMatch(page -> (page > 400 || page < 1)))
			// 1 ~ 400 범위 밖의 페이지 인 경우
			return true;
		return false;
	}

	public static boolean isFirstPage(List<Integer> pages) {
		if (pages.get(0) == 1 && pages.get(1) == 2)
			return false;
		return true;
	}

	public static boolean isLastPage(List<Integer> pages) {
		if (pages.get(0) == 399 && pages.get(1) == 400)
			return false;
		return true;
	}
}