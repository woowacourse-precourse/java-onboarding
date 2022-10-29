package onboarding;

import java.util.List;

class Problem1 {
	public static final int ERROR_CODE = -1;

	public static int solution(List<Integer> pobi, List<Integer> crong) {
		int answer = Integer.MAX_VALUE;

		if (isValidCondition(pobi) && isValidCondition(crong))
			return ERROR_CODE;

		return answer;
	}

	/**
	 * 1. 제한사항 체크
	 */
	public static boolean isValidCondition(List<Integer> pages) {
		if (pages.size() != 2)            // 리스트의 길이가 2 이상인 경우
			return false;
		if (pages.get(0) >= pages.get(1)) //왼쪽 오른쪽 페이지 순서로 있지 않은 경우
			return false;
		return true;
	}
}