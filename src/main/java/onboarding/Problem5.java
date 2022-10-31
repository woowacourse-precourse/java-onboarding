package onboarding;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        return answer = countMoney(money);
    }

    public static List<Integer> countMoney(int money) {
        List<Integer> units = List.of(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1);
        List<Integer> countedMoneyList = new ArrayList<>();
        for (int m : units) {
            countedMoneyList.add(money / m);
            money %= m;
        }
        return countedMoneyList;
    }
}
