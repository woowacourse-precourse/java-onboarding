package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static final List<Integer> MONEY_LIST = Arrays.asList(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1);

    public static List<Integer> changeMoney(int money) {
        ArrayList<Integer> result = new ArrayList<>();

        for (int divisor : MONEY_LIST) {
            result.add(money / divisor);
            money %= divisor;
        }

        return result;
    }

    public static List<Integer> solution(int money) {
        return changeMoney(money);
    }
}
