package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    private static final int[] MONEY_LIST = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
    public static List<Integer> solution(int money) {
        checkValidRange(money);
        List<Integer> answer = getResult(money);

        return answer;

    }

    private static List<Integer> getResult(int money) {
        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < MONEY_LIST.length; i++) {
            money = getRemainMoney(money, answer, i);
        }
        return answer;
    }

    private static int getRemainMoney(int money, List<Integer> answer, int i) {
        int count = 0;
        if (money >= MONEY_LIST[i]) count = money / MONEY_LIST[i];
        money = money - MONEY_LIST[i] * count;
        answer.add(count);
        return money;
    }

    private static void checkValidRange(final int money) {
        if (money < 1 || money > 1000000) {
            throw new IllegalArgumentException();
        }
    }
}
