package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
	private static final int[] moneySpecifications = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

	public static List<Integer> solution(int money) {
		List<Integer> answer = new ArrayList<>();
		for (int spec : moneySpecifications) {
			answer.add(money / spec);
			money %= spec;
		}
		return answer;
	}
}
