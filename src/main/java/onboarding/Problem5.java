package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        final int[] MONEY_TYPE = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

        countChanges(MONEY_TYPE, answer, money);

        return answer;
    }

    private static void countChanges(int[] MONEY_TYPE, List<Integer> answer, int money) {
        int balance = money;
        for (int i=0; i<MONEY_TYPE.length; i++) {
            int count = balance/MONEY_TYPE[i];
            if (count != 0) {
                balance -= count*MONEY_TYPE[i];
                answer.add(count);
                continue;
            }
            answer.add(0);
        }
    }
}
