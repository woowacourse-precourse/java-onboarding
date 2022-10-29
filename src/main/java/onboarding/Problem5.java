package onboarding;

import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> result = Collections.emptyList();
        while (money > 0) {
            if (money >= 50000) {
                result.add(money / 50000);
                money %= 50000;
            } else if (money >= 10000) {
                result.add(money / 10000);
                money %= 10000;
            } else if (money >= 5000) {
                result.add(money / 5000);
                money %= 5000;
            } else if (money >= 1000) {
                result.add(money / 1000);
                money %= 1000;
            } else if (money >= 100) {
                result.add(money / 100);
                money %= 100;
            } else if (money >= 50) {
                result.add(money / 50);
                money %= 50;
            } else if (money >= 10) {
                result.add(money / 10);
                money %= 10;
            } else if (money >= 1) {
                result.add(money / 1);
                money %= 1;
            }
        }
        return result;
    }
}
