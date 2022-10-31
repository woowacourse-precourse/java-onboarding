package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        Withdrawal withdraw = Withdrawal.getInstance();
        return withdraw.getAnswer(money);
    }
}


class Withdrawal {
    private static Withdrawal withdrawal = new Withdrawal();

    static Withdrawal getInstance() {
        return withdrawal;
    }

    private List<Integer> money_array = new ArrayList<>(9);

    private Withdrawal() {
        setMoney_array(this.money_array);
    }

    private void setMoney_array(List<Integer> money_array) {
        int m = 50000;
        for (int i = 0; i < 8; i++) {
            int e = (int) Math.pow(10, i / 2);
            if (i % 2 == 0) {
                money_array.add(m / e);
            } else {
                money_array.add(m / (e * 5));
            }
        }
        money_array.add(1);
    }

    List<Integer> getAnswer(int money) {
        List<Integer> answer = Arrays.asList(0,0,0,0,0,0,0,0,0);
        for (int i = 0; i < 9; i++) {
            int m = money_array.get(i);
            if (money < m) {
                continue;
            }
            int q = money / m;
            answer.set(i, q);
            money = money % m;
        }
        return answer;
    }
}
