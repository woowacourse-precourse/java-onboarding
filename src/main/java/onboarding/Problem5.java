package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem5 {
	public static final List<Integer> MONEY_LIST = Arrays.asList(50000, 10000, 5000, 1000, 500, 100, 50, 10);

	public static List<Integer> solution(int money) {
		List<Integer> answer = new ArrayList<>();
		for (Integer exchange : MONEY_LIST) {
			answer.add(money / exchange);
			money %= exchange;
		}
		answer.add(money);
		return answer;
	}
}
