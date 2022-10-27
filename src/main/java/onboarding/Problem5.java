package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();

        answer = convertIntoMoneyUnit(money);

        return answer;
    }

    private static List<Integer> convertIntoMoneyUnit(int money) {
        List<Integer> moneyUnit = new ArrayList<>();

        moneyUnit.add(money / 50000);
        money %= 50000;
        moneyUnit.add(money / 10000);
        money %= 10000;
        moneyUnit.add(money / 5000);
        money %= 5000;
        moneyUnit.add(money / 1000);
        money %= 1000;
        moneyUnit.add(money / 500);
        money %= 500;
        moneyUnit.add(money / 100);
        money %= 100;
        moneyUnit.add(money / 50);
        money %= 50;
        moneyUnit.add(money / 10);
        money %= 10;
        moneyUnit.add(money);

        return moneyUnit;
    }
}
