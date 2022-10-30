package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }

	private static int sum(int num) {
		int ret = 0;

		while(num > 0) {
			ret += num % 10;
			num /= 10;
		}

		return ret;
	}
}
