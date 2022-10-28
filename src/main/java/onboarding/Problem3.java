package onboarding;

import java.util.stream.IntStream;

public class Problem3 {

	public static final int MOD = 10;
	public static final int THREE = 3;

	public static int solution(int number) {
		return IntStream.rangeClosed(1, number)
			.map(Problem3::getClapCount)
			.sum();
	}

	public static int getClapCount(int num) {
		int cnt = 0;
		while (num > 0) {
			int curNum = num % MOD;
			if (curNum != 0 && curNum % THREE == 0) {
				cnt++;
			}
			num /= MOD;
		}
		return cnt;
	}

}
