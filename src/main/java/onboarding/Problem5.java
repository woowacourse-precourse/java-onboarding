package onboarding;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    static final List<Integer> moneyList = Arrays.asList(50000, 10000, 5000, 500, 100, 50, 10);
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();

        System.out.println(getCountByUnit(money, moneyList.get(0)));
        return answer;
    }

    private static Integer getCountByUnit(int money, int unit) {
        return money >= unit ? money / unit : 0;
    }
}
