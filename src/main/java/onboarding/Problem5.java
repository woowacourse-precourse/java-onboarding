package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    static class MoneyChange {

        int[] moneyGrade = new int[9];

        MoneyChange() {
            moneyGrade[0] = 50000;
            moneyGrade[1] = 10000;
            moneyGrade[2] = 5000;
            moneyGrade[3] = 1000;
            moneyGrade[4] = 500;
            moneyGrade[5] = 100;
            moneyGrade[6] = 50;
            moneyGrade[7] = 10;
            moneyGrade[8] = 1;

        }

        private List<Integer> calculatorMoney(int money) {
            List<Integer> res = new ArrayList<>(Collections.emptyList());

            for (int i = 0; i < moneyGrade.length; i++) {
                res.add(shareMoney(money, i));
                money = calculator(shareMoney(money, i), money, i);
            }

            return res;
        }

        private int shareMoney(int money, int idx) {
            return money / moneyGrade[idx];
        }

        private int calculator(int count, int money, int idx) {
            if (count != 0) {
                money -= moneyGrade[idx] * count;
            }

            return money;
        }
    }

    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();

        MoneyChange moneyChange = new MoneyChange();
        answer = moneyChange.calculatorMoney(money);

        return answer;
    }
}
