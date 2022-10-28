package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {

    static final int[] MONETARY_UNITS = {50_000, 10_000, 5_000, 1_000, 500, 100, 50, 10, 1};

    public static List<Integer> solution(int money) {
        return getChange(money);
    }

    private static List<Integer> getChange(int money) {
        List<Integer> result = new ArrayList<>();
        int targetMoney = money;
        for (int i = 0; i < MONETARY_UNITS.length; i++) {
            int unitNum = 0;
            if (targetMoney >= MONETARY_UNITS[i]) {
                unitNum = targetMoney / MONETARY_UNITS[i];
                targetMoney -= unitNum * MONETARY_UNITS[i];
            }
            result.add(unitNum);
        }
        return result;
    }
}
