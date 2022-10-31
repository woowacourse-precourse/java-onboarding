package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
	public static List<Integer> solution(int money) {
		if (!isValidNumber(money)) {
			return Collections.emptyList();
		}

		List<Integer> answer = changeMoney(money);
		return answer;
	}

	private static boolean isValidNumber(int money) {
		return money >= 1 && money <= 1000000;
	}

	private static List<Integer> changeMoney(int money) {
		List<Integer> answer = new ArrayList<>();
		int[] unit = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
		int realMoney = money;

		for (int u : unit) {
			int cnt = realMoney / u;
			realMoney %= u;
			answer.add(cnt);
		}

		return answer;
	}
}
