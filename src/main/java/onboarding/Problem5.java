package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {

    private static final List<Integer> moneyUnit = List.of(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1);

    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        return convertMoneyByUnit(money, answer);
    }

    private static List<Integer> convertMoneyByUnit(int money, List<Integer> list) {
        for (int i : moneyUnit) {
            if (money / i > 0) {
                list.add(money / i);
                money %= i;
            } else {
                list.add(0);
            }
        }
        return list;
    }
}
