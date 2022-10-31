package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {

    // 돈 변환
    private static List<Integer> convert(int money) {
        List<Integer> moneyCount =
                new ArrayList<>(List.of(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1));
        int current = 0;
        int amountOfMoney;

        while(current < moneyCount.size()) {
            amountOfMoney = moneyCount.get(current);
            moneyCount.set(current, money / amountOfMoney);
            money %= amountOfMoney;
            current++;
        }
        return moneyCount;
    }

    public static List<Integer> solution(int money) {
        return convert(money);
    }
}