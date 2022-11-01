package onboarding;

import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static int[] solution(int money) {
        int[] moneyCount = new int[9];
        int[] moneyAmount = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

        for (int i = 0; i < moneyCount.length; i++) {
            if (money / moneyAmount[i] >= 1)
                moneyCount[i] = money / moneyAmount[i];
            else
                moneyCount[i] = 0;

            money = money % moneyAmount[i];
        }

        return moneyCount;
    }
}
