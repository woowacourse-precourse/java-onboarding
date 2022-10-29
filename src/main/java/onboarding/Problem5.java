package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        int[] moneyList = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
        List<Integer> moneyCount = new ArrayList<>();

        for (int i = 0; i < moneyList.length; i++) {
            moneyCount.add(money / moneyList[i]);
            money %= moneyList[i];
        }

        return moneyCount;
    }
}
