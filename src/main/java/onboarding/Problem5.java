package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        int[] units = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

        List<Integer> sorted = new ArrayList<>();

        while (money > 0) {
            for (int unit: units) {
                if (money / unit >= 1) {
                    sorted.add((int) Math.floor(money/unit));
                    money = money % unit;
                } else {
                    sorted.add(0);
                }
            }
        }

        return sorted;
    }
}
