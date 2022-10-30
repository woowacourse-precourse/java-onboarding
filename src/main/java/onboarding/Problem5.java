package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    private static final int[] moneyType = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

    public static List<Integer> solution(int money) {
        List<Integer> answer = getCount(money);
        return answer;
    }

    public static List<Integer> getCount(int money) {
        List<Integer> countOfMoneySortedByType = new ArrayList<>();
        int mod = 0;

        for (int i = 0; i < moneyType.length; i++) {
            if (money >= moneyType[i]) {
                mod = money / moneyType[i];
                money -= (mod * moneyType[i]);
                countOfMoneySortedByType.add(mod);
                continue;
            }
            countOfMoneySortedByType.add(0);
        }
        return countOfMoneySortedByType;
    }
}
