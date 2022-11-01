package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    static final int[] moneyUnits = new int[]{50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

    public List<Integer> calculateMoney(List<Integer> answer, int money) {
        for (int unit : moneyUnits) {
            answer.add(getMoneyCount(money, unit));
            money = examineChange(money, unit);
        }

        return answer;
    }

    public Integer getMoneyCount(int money, int unit) {
        return money / unit;
    }

    public int examineChange(int money, int unit) {
        if(money <= 0) {
            return 0;
        }
        return money % unit;
    }

    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();

        Problem5 problem5 = new Problem5();
        answer = problem5.calculateMoney(answer, money);

        return answer;
    }
}
