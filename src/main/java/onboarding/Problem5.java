package onboarding;

import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
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
        W_500(500), W_100(100), W_50(50), W_10(10), W_1(1),
        W_0(0);

        private final int value;

        CURRENCY(int value) {
            this.value = value;
        }

        public static boolean noMoreMoney(int money) {
            return W_0.value == money;
        }

        public int getValue() {
            return value;
        }
    }
}
