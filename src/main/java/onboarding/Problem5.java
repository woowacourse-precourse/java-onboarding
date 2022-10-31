package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    private static final List<CURRENCY> CURRENCY_LIST = List.of(CURRENCY.values());

    public static List<Integer> solution(int money) {
		List<Integer> answer = new ArrayList<>();

		for (CURRENCY UNIT : CURRENCY_LIST) {
			int count = countMaxNumberOfCurrencies(UNIT, money);
			answer.add(count);
			money = remainedMoney(UNIT, money);
		}

        return answer;
    }

    public static int countMaxNumberOfCurrencies(final CURRENCY UNIT, int money) {
        return money / UNIT.getValue();
    }

    public static int remainedMoney(final CURRENCY UNIT, int money) {
        int count = countMaxNumberOfCurrencies(UNIT, money);
        int transformedMoney = UNIT.getValue() * count;

        return money - transformedMoney;
    }

    enum CURRENCY {
        W_50000(50000), W_10000(10000), W_5000(5000), W_1000(1000),
        W_500(500), W_100(100), W_50(50), W_10(10), W_1(1);

        private final int value;

        CURRENCY(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }
}
