package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem5 {
    private static final List<Integer> moneyUnits = Arrays.asList(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1);

    public static List<Integer> solution(int money) {
        return changeCash(money);
    }

    private static List<Integer> changeCash(int money) {
        List<Integer> changeCashes = new ArrayList<>();
        for (Integer moneyUnit : moneyUnits) {
            changeCashes.add(money / moneyUnit);
            money %= moneyUnit;
        }
        return changeCashes;
    }
}