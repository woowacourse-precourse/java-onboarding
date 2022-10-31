package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
	public static List<Integer> solution(int money) {
		return Purse.calculate(money);
	}

	public enum Purse {
		FIFTY_THOUSAND(50_000),
		TEN_THOUSAND(10_000),
		FIVE_THOUSAND(5_000),
		THOUSAND(1_000),
		FIVE_HUNDRED(500),
		HUNDRED(100),
		FIFTY(50),
		TEN(10),
		ONE(1);

		private final int money;

		Purse(int money) {
			this.money = money;
		}

		public static List<Integer> calculate(int account) {
			List<Integer> money = new ArrayList<>();

			for (Purse moneyType : Purse.values()) {
				int count = moneyType.countMoney(account);

				money.add(count);
				account -= moneyType.totalChangeFare(count);
			}

			return money;
		}

        public int countMoney(int account) {
            int count = 0;
            while (canChange(account)) {
                account -= money;
                count++;
            }
            return count;
        }

        private boolean canChange(int account) {
            return account - money >= 0;
        }

        private int totalChangeFare(int count) {
            return money * count;
        }
	}
}
