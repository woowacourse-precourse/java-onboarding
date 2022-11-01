package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();

        answer = convertIntoMoneyUnitList(money);

        return answer;
    }

    private static List<Integer> convertIntoMoneyUnitList(int money) {
        List<Integer> moneyUnitList = new ArrayList<>();

        moneyUnitList.add(money / 50000);
        money %= 50000;
        moneyUnitList.add(money / 10000);
        money %= 10000;
        moneyUnitList.add(money / 5000);
        money %= 5000;
        moneyUnitList.add(money / 1000);
        money %= 1000;
        moneyUnitList.add(money / 500);
        money %= 500;
        moneyUnitList.add(money / 100);
        money %= 100;
        moneyUnitList.add(money / 50);
        money %= 50;
        moneyUnitList.add(money / 10);
        money %= 10;
        moneyUnitList.add(money);

        return moneyUnitList;
    }
}
