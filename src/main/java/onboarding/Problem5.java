package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Problem5 {

    public static List<Integer> solution(int money) {
        return withdraw(money);
    }

    private static List<Integer> withdraw(int amount) {
        List<Integer> result = new ArrayList<>();

        for (Money changes : Money.highestOrder()) {
            int count = amount / changes.value;
            result.add(count);
            amount = amount - (count * changes.value);
        }

        return result;
    }


    enum Money {
        _50000_WON(50000),
        _10000_WON(10000),
        _5000_WON(5000),
        _1000_WON(1000),
        _500_WON(500),
        _100_WON(100),
        _50_WON(50),
        _10_WON(10),
        _1_WON(1);

        int value;

        Money(int value) {
            this.value = value;
        }

        public static List<Money> highestOrder() {
            return Arrays.stream(values())
                    .sorted((o1, o2) -> o2.value - o1.value)
                    .collect(Collectors.toList());
        }
    }
}
