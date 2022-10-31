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

    enum CURRENCY {
        W_50000(50000), W_10000(10000), W_5000(5000),
        W_1000(1000), W_500(500), W_100(100), W_50(50), W_10(10), W_1(1);

        private final int value;

        CURRENCY(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }
}
