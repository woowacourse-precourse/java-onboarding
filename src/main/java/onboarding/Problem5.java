package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {

    private static final List<Integer> MONEY_TYPES = List.of(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1);

    public static List<Integer> solution(int money) {
        return withdrawMoney(money);
    }

    private static List<Integer> withdrawMoney(int money) {
        List<Integer> result = new ArrayList<>();
        for (Integer moneyType : MONEY_TYPES) {
            result.add(count(money, moneyType));
            money %= moneyType;
        }
        return result;
    }

    private static int count(int money, int moneyType) {
        return money / moneyType;
    }
}
