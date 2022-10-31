package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        List<Integer> moneyList = new ArrayList<>();
        moneyList.add(money / 50000);
        money = money - (50000 * (money / 50000));
        moneyList.add(money / 10000);
        money = money - (10000 * (money / 10000));
        moneyList.add(money / 5000);
        money = money - (5000 * (money / 5000));
        moneyList.add(money / 1000);
        money = money - (1000 * (money / 1000));
        moneyList.add(money / 500);
        money = money - (500 * (money / 500));
        moneyList.add(money / 100);
        money = money - (100 * (money / 100));
        moneyList.add(money / 50);
        money = money - (50 * (money / 50));
        moneyList.add(money / 10);
        money = money - (10 * (money / 10));
        moneyList.add(money);
        money = 0;
        answer = moneyList;
        return answer;
    }
}
