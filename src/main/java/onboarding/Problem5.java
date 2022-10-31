package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        return Money.calculate(money);
    }

    static class Money {
        private final static List<Integer> moneyUnits = List.of(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1);

        private Money() {
        }

        public static List<Integer> calculate(int value) {
            List<Integer> result = new ArrayList<>();
            for (Integer unit : moneyUnits) {
                result.add(value / unit);
                value %= unit;
            }
            return result;
        }
    }
}
