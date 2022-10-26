package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    static List<Integer> moneyUnit = Arrays.asList(50_000, 10_000, 5_000, 1_000, 500, 100, 50, 10, 1);
    public static List<Integer> solution(int money) {
        return getUnitCount(money);
    }

    private static List<Integer> getUnitCount(int money) {
        List<Integer> unitCount = new ArrayList<>();
        for (int i = 0; i < moneyUnit.size(); i++) {
            unitCount.add(money / moneyUnit.get(i));
            money %= moneyUnit.get(i);
        }
        return unitCount;
    }
}
