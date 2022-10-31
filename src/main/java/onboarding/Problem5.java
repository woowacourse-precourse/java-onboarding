package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    private static final List<Integer> units = new ArrayList<>(List.of(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1));

    private static void checkMoney(int money) {
        if (money > 1000000 || money < 1)
            throw new IllegalArgumentException("올바른 범위가 아닌 입력값입니다.");
    }

    private static List<Integer> withdraw(int money) {
        List<Integer> list = new ArrayList<>();
        for (Integer unit : units) {
            list.add(money / unit);
            money %= unit;
        }
        return list;
    }

    public static List<Integer> solution(int money) {
        checkMoney(money);
        return withdraw(money);
    }
}
