package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
	static final List<Integer> monetaryUnits = List.of(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1);

	public static List<Integer> solution(int money) {
		return getResults(money);
	}

	private static List<Integer> getResults(int money) {
		List<Integer> results = new ArrayList<>();
		int remainder = money;
		for (int monetaryUnit : monetaryUnits) {
			int result = remainder / monetaryUnit;
			results.add(result);
			remainder %= monetaryUnit;
		}
		return results;
	}
}
