package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        return Calculator.calculateMoney(money);
    }

    public enum Calculator {
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

        Calculator(int money) {
            this.money = money;
        }

        public int getMoney() {
            return money;
        }

        public static List<Integer> calculateMoney(int account) {
            Calculator[] types = Calculator.values();

            List<Integer> money = new ArrayList<>();
            for (Calculator type : types) {
                int count = getCount(type, account);
                money.add(count);
                account -= type.getMoney() * count;
            }

            return money;
        }

        public static int getCount(Calculator money, int account) {
            int count = 0;
            while (account - money.getMoney() >= 0) {
                account -= money.getMoney();
                count++;
            }
            return count;
        }
    }
}
