package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem5 {
	private static class Money {
		static final int[] moneyList = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
		static final String invalidArgument = "InvalidArgument";
	}

	private static class ValidationMoney extends CalculationMoney {
		public static boolean isDivide(int money) {
			return (money / divideMoney) > 0;
		}

		public static boolean isValidAmount(int money) {
			return (money >= 1) && (money <= 1_000_000);
		}
	}

	private static class CalculationMoney {
		static int divideMoney;

		public static void setDivideMoney(int money) {
			divideMoney = money;
		}

		public static int divide(int money) {
			return money / divideMoney;
		}

		public static int countRemainder(int money) {
			return money % divideMoney;
		}
	}

	public static List<Integer> solution(int money) {
		int caseMoney;
		List<Integer> answer = new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0, 0));
		if (!ValidationMoney.isValidAmount(money)) {
			System.out.println(Money.invalidArgument);
		}
		for (caseMoney = 0; caseMoney < Money.moneyList.length - 1; caseMoney++) {
			CalculationMoney.setDivideMoney(Money.moneyList[caseMoney]);
			if (ValidationMoney.isDivide(money)) {
				answer.set(caseMoney, CalculationMoney.divide(money));
				money = CalculationMoney.countRemainder(money);
			}
		}
		answer.set(caseMoney, money);
		return answer;
	}
}
