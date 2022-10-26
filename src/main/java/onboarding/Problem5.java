package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {

	private final static List<Integer> moneyType = List.of(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1);

	public static List<Integer> solution(int money) {
		List<Integer> answer = new ArrayList<>();
		for (Integer price : moneyType) {
			int count = 0;
			if (money / price > 0) {
				count += money / price;
				money %= price;
			}
			answer.add(count);
		}
		return answer;
	}
}
