package onboarding;

import java.util.List;

class Problem1 {
	public static int solution(List<Integer> pobi, List<Integer> crong) {
		int answer = Integer.MAX_VALUE;

		// 값 검증
		if (validateNum(pobi) == -1 || validateNum(crong) == -1)
			return -1;

		return answer;
	}

	// 올바르면 1, 이상하면 -1을 return
	private static int validateNum(List<Integer> lst) {
		if (lst.get(0) < 1 || lst.get(1) > 400)
			return -1;
		if (lst.get(0) % 2 == 0 || lst.get(1) % 2 == 1)
			return -1;
		if (lst.get(0) + 1 != lst.get(1))
			return -1;

		return 1;
	}
}