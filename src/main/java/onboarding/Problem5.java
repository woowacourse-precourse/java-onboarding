package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    private static final List<Integer> MONEY_UNIT = List.of(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1);

    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        answer = List.copyOf(convert(money));
        return answer;
    }

    private static List<Integer> convert(int money) {
        List<Integer> unit = new ArrayList<>();
        int tmp = money;

        for(Integer i : MONEY_UNIT) {
            unit.add(tmp / i);
            tmp = tmp % i;
        }
        return unit;
    }
}
