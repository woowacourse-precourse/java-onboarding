package onboarding;

import java.util.List;

public class Problem5 {

	public static List<Integer> solution(int money) {
		return Bank.convert(money);
	}

	public enum Money {
		_50000WON(50_000),
		_10000WON(10_000),
		_5000WON(5_000),
		_1000WON(1_000),
		_500WON(500),
		_100WON(100),
		_50WON(50),
		_10WON(10),
		_1WON(1),
		;
		private final int amount;

		Money(int amount) {
			this.amount = amount;
		}

		public int getAmount() {
			return amount;
		}
	}

	public static class Bank {

		public static List<Integer> convert(int money) {
			return null;
		}

	}

}
