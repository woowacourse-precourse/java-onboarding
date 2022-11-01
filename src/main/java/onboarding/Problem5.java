package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class CalculateChange {
    int[] wallet = new int[9];
    List<Integer> temp = Collections.emptyList();

    CalculateChange(int money) throws RestrictException {
        if (money < 1 || money > 1_000_000) {
            throw new RestrictException("OutOfRange");
        } else {
            int start = 50000;
            for (int i = 0; i < 8; i++) {
                if (i % 2 == 0) {
                    wallet[i] = money / start;
                    money %= start;
                    start /= 5;
                } else {
                    wallet[i] = money / start;
                    money %= start;
                    start /= 2;
                }
            }
            wallet[8] = money;
        }
    }
}

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        try {
            CalculateChange changedMoney = new CalculateChange(money);
            for (int i = 0; i < 9; i++) {
                answer.add(i, changedMoney.wallet[i]);
            }
        } catch (RestrictException e) {
            System.out.println(e.exMsg);
        }
        return answer;
    }
}
