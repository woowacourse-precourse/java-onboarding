package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    static int[] moneyArray = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
    public static List<Integer> solution(int money) {
        if (money > 1_000_000 || money < 1) {
            return new ArrayList<>(List.of(0, 0, 0, 0, 0, 0, 0, 0, 0));
        }

        List<Integer> answer = new ArrayList<>();
        for (int moneyUnit : moneyArray) {
            answer.add(calculateMoneyNum(moneyUnit, money));
            money = calculateBalance(moneyUnit, money);
        }
        return answer;
    }

    public static int calculateMoneyNum(int moneyUnit, int usingMoney) {
        return usingMoney / moneyUnit;
    }

    public static int calculateBalance(int moneyUnit, int balance) {
        return balance - moneyUnit * (balance / moneyUnit);
    }
}
