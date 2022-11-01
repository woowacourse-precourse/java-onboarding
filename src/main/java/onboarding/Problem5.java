package onboarding;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    private static final List<Integer> CURRENCY_UNITS
        = Arrays.asList(50000, 10000, 5000, 1000,
        500, 100, 50, 10, 1);

    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();

        splitMoneyByCurrencyUnits(money, answer);

        return answer;
    }

    private static void splitMoneyByCurrencyUnits(int money, List<Integer> answer) {
        int index = 0;
        int count = 0;
        while (money > 0) {
            count = splitMoneyByCurrencyUnit(money, index);
            answer.add(index, count);
            money %= CURRENCY_UNITS.get(index);
            index += 1;
        }
    }
}
