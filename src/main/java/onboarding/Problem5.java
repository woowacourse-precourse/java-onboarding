package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
	private static final int MIN_MONEY = 1;
	private static final int MAX_MONEY = 1000000;
	private static final List<Integer> MONEY_TYPE = List.of(
		50000, 10000, 5000, 1000, 500, 100, 50, 10, 1);

	public static List<Integer> solution(int money) {
		if (!isMoneyRange(money)) {
			throw new IllegalArgumentException();
		}
		List<Integer> paperMoney = new ArrayList<>();
		for (int changeMoney : MONEY_TYPE) {
			paperMoney.add(money / changeMoney);
			money %= changeMoney;
		}
		return paperMoney;
	}

	private static boolean isMoneyRange(int money) {
		return money >= MIN_MONEY && money <= MAX_MONEY;
	}
}
