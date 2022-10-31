package onboarding;

import java.util.List;

class Problem1 {
	private static boolean isValidList(List<Integer> list) {
		int left;
		int right;

		left = list.get(0);
		right = list.get(1);
		return (list.size() == 2
				&& right - left == 1
				&& 1 < left && left < 400
				&& left % 2 == 1
				&& 1 < right && right < 400
				&& right % 2 == 0);
	}
	public static int solution(List<Integer> pobi, List<Integer> crong) {
		int answer = Integer.MAX_VALUE;
		return answer;
	}
}