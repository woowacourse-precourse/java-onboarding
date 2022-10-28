package onboarding;

import java.util.Collections;
import java.util.List;

public class Problem5 {
    private static List<Integer> withdraw(int money){
        List<Integer> moneyList = Collections.emptyList();

        moneyList.add(money / 50000);
        money %= 50000;
        moneyList.add(money / 10000);
        money %= 10000;
        moneyList.add(money / 5000);
        money %= 5000;
        moneyList.add(money / 1000);
        money %= 1000;
        moneyList.add(money / 500);
        money %= 500;
        moneyList.add(money / 100);
        money %= 100;
        moneyList.add(money / 50);
        money %= 50;
        moneyList.add(money / 10);
        money %= 10;
        moneyList.add(money);

        return moneyList;
    }

    public static List<Integer> solution(int money) {
        return withdraw(money);
    }
}
