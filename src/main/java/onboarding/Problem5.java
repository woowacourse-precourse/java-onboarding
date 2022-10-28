package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    private static final int[] MONEY_LIST = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
    public static List<Integer> solution(int money) {
        checkValidRange(money);
        List<Integer> answer = Collections.emptyList();

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < MONEY_LIST.length; i++) {
            int count = 0;
            if (money >= MONEY_LIST[i]){
                count = money / MONEY_LIST[i];
            }
            money = money - MONEY_LIST[i] * count;
            result.add(count);
        }

        answer = result;
        return answer;

    }

    private static void checkValidRange(final int money) {
        if (money < 1 || money > 1000000) {
            throw new IllegalArgumentException();
        }
    }
}
