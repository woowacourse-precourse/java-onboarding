package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Problem5 {
    static final List<Integer> moneyList = Arrays.asList(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1);
    public static List<Integer> solution(int money) {
        return getCountList(money);
    }

    private static List<Integer> getCountList(int money) {
        List<Integer> result = new ArrayList<>();

        for (int unit: moneyList) {
            int count = getCountByUnit(money, unit);
            result.add(count);
            money -= count * unit;
        }

        return result;
    }

    private static Integer getCountByUnit(int money, int unit) {
        return money >= unit ? money / unit : 0;
    }
}



