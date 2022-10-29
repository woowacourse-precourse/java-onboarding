package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> withdrawMoney(int money) {
        int[] currencyType = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
        List<Integer> currencyCount = new ArrayList<>(Collections.nCopies(currencyType.length, 0));

        for(int i = 0; i < currencyType.length; i++) {
            if(currencyType[i] <= money) {
                int cnt = money / currencyType[i];
                currencyCount.set(i, cnt);
                money %= currencyType[i];
            }
        }

        return currencyCount;
    }

    public static List<Integer> solution(int money) {
        return withdrawMoney(money);
    }
}
