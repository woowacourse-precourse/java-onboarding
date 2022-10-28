package onboarding;

import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> result = Collections.emptyList();
        changeMoney(money);
        return result;
    }

    private static void changeMoney(int money) {
        int money50000;
        if (money / 50000 != 0) {
            money50000 = money / 50000;
            money -= money50000 * 50000;
        }

        int money10000;
        if (money / 10000 != 0) {
            money10000 = money / 10000;
            money -= money10000 * 10000;
        }

        int money5000;
        if (money / 5000 != 0) {
            money5000 = money / 5000;
            money -= money5000 * 5000;
        }

        int money1000;
        if (money / 1000 != 0) {
            money1000 = money / 1000;
            money -= money1000 * 1000;
        }

        int money500;
        if (money / 500 != 0) {
            money500 = money / 500;
            money -= money500 * 500;
        }

        int money100;
        if (money / 100 != 0) {
            money100 = money / 100;
            money -= money100 * 100;
        }

        int money50;
        if (money / 50 != 0) {
            money50 = money / 50;
            money -= money50 * 50;
        }

        int money10;
        if (money / 10 != 0) {
            money10 = money / 10;
            money -= money10 * 10;
        }

        int money1;
        if (money / 1 != 0) {
            money1 = money / 1;
            money -= money1 * 1;
        }
    }
}
