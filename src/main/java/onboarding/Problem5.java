package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static int minusMoney(int money, int standard) {
        money = money - (money / standard) * standard;
        return money;
    }

    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        answer = new ArrayList<Integer>(Collections.nCopies(9,0));

        while (money > 0) {
            if (money / 50000 != 0) {
                answer.set(0, money / 50000);
                money = minusMoney(money, 50000);
                continue;
            }

            if (money / 10000 != 0) {
                answer.set(1, money / 10000);
                money = minusMoney(money, 10000);
                continue;
            }

            if (money / 5000 != 0) {
                answer.set(2, money / 5000);
                money = minusMoney(money, 5000);
                continue;
            }

            if (money / 1000 != 0) {
                answer.set(3, money / 1000);
                money = minusMoney(money, 1000);
                continue;
            }

            if (money / 500 != 0) {
                answer.set(4, money / 500);
                money = minusMoney(money, 500);
                continue;
            }

            if (money / 100 != 0) {
                answer.set(5, money / 100);
                money = minusMoney(money, 100);
                continue;
            }

            if (money / 50 != 0) {
                answer.set(6, money / 50);
                money = minusMoney(money, 50);
                continue;
            }

            if (money / 10 != 0) {
                answer.set(7, money / 10);
                money = minusMoney(money, 10);
                continue;
            }

            if (money / 1 != 0) {
                answer.set(8, money / 1);
                money = minusMoney(money, 1);
            }
        }
        return answer;
    }
}
