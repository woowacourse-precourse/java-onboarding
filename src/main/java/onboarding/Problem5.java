package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
		return Bank.exchangesCurrencies(money);
    }

	private static class Bank {
		private final static int NO_EXCHANGED_MONEY = 0;
		private enum Money {
			FIFTY_THOUSAND(50000),
			TEN_THOUSAND(10000),
			FIVE_THOUSAND(5000),
			ONE_THOUSAND(1000),
			FIVE_HUNDRED(500),
			ONE_HUNDRED(100),
			FIFTY(50),
			TEN(10),
			ONE(1);

			private final int price;
			Money(int price) {
				this.price = price;
			}

			int exchange(int totalMoney) {
				return (totalMoney / this.price);
			}
		}

		public static List<Integer> exchangesCurrencies(int totalMoney) {
			List<Integer> exchangedCurrencies = new ArrayList<>();
			for (Money currentMoney : Money.values()) {
				if (totalMoney < currentMoney.price) {
					exchangedCurrencies.add(NO_EXCHANGED_MONEY);
					continue;
				}
				exchangedCurrencies.add(currentMoney.exchange(totalMoney));
				totalMoney %= currentMoney.price;
			}
			return exchangedCurrencies;
		}
	}
}
