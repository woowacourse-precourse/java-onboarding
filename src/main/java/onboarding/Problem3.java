package onboarding;

import java.util.HashSet;
import java.util.Set;

import onboarding.problem3.CountPool;
import onboarding.problem3.game369.Game369CountPool;

public class Problem3 {

	private static final CountPool countPool = new Game369CountPool();

	public static int solution(int number) {
		int answer = 0;
		for (int i = 1; i <= number; i++) {
			int tmpNum = i;
			answer += count369(tmpNum);
		}

		return answer;
	}

	// ex. 334
	// return 2
	private static int count369(int number) {
		int count = 0;
		while (number > 0) {
			count = updateCount(number, count);
			number /= 10;
		}
		return count;
	}

	private static int updateCount(int number, int count) {
		if (countPool.countable(number % 10)) {
			count++;
		}
		return count;
	}
}
