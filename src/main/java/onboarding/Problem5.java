package onboarding;

import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static int calculateMoney(int money) {
        return money;
    }
    public static List<Integer> solution(int money) {
        List<Integer> result = Collections.emptyList();
        int[] moneyArray;
        moneyArray = new int[9];

        while (money > 0) {
            if (money % 50000 == 0) {
                money /= 50000;
                moneyArray[0] += 1;
            } else if (money % 10000 == 0) {
                money /= 10000;
                moneyArray[1] += 1;
            } else if (money % 5000 == 0) {
                money /= 5000;
                moneyArray[2] += 1;
            } else if (money % 1000 == 0) {
                money /= 1000;
                moneyArray[3] += 1;
            } else if (money % 500 == 0) {
                money /= 500;
                moneyArray[4] += 1;
            } else if (money % 100 == 0) {
                money /= 100;
                moneyArray[5] += 1;
            } else if (money % 50 == 0) {
                money /= 50;
                moneyArray[6] += 1;
            } else if (money % 10 == 0) {
                money /= 10;
                moneyArray[7] += 1;
            } else if (money % 1 == 0) {
                money /= 1;
                moneyArray[8] += 1;
            }
        }
        for (int i = 0; i < 9; i++) {
            result.add(moneyArray[i]);
        }
        return result;
    }
}
