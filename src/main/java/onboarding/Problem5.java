package onboarding;

import java.util.Collections;
import java.util.List;

public class Problem5 {
    private static final int[] MONEY_LIST = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
    public static List<Integer> solution(int money) {
        for (int u : MONEY_LIST) {
            money = divideMoney(money, u);
        }
        List<Integer> answer = Collections.emptyList();
        return answer;
    }

    public static int divideMoney(int money, int unit) {
        return money % unit;
    }
}
