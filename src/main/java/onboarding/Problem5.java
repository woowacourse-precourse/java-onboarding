package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
	static final List<Integer> monetaryUnits = List.of(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1);

	public static List<Integer> solution(int money) {
		return returnResult(money);
	}

	private static List<Integer> returnResult(int money) {
		List<Integer> result = new ArrayList<>();
		for (int monetaryUnit : monetaryUnits) {
			result.add(exchange(money, monetaryUnit));
			money -= exchange(money, monetaryUnit) * monetaryUnit;
		}
		return result;
	}

	private static int exchange(int money, int monetaryUnit) {
		return money / monetaryUnit;
	}
}
