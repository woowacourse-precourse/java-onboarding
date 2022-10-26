package onboarding;

import java.util.Collections;
import java.util.List;

public class Problem5 {
    private static final int[] MONEY_LIST = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
    public static List<Integer> solution(int money) {
        checkValidRange(money);
        List<Integer> answer = Collections.emptyList();

        return answer;
    }

    private static void checkValidRange(int money) {
        if (money < 1 || money > 1000000) {
            throw new IllegalArgumentException();
        }
    }
}
