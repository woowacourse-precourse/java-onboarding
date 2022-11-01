package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
	public static List<Integer> solution(int money) {
		MoneyDivider moneyDivider = new MoneyDivider();
		List<Integer> answer = moneyDivider.divideMoney(money);
		return answer;
	}

	static class MoneyDivider {
		List<Integer> units = List.of(50_000, 10_000, 5000, 1000, 500, 100, 50, 10, 1);

		public List<Integer> divideMoney(int money) {
			List<Integer> result = new ArrayList<>();
			for (int unit : units) {
				result.add(money / unit);
				money %= unit;
			}
			return result;
		}
	}

}
