package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = MoneyLoop(money);
        if (answer.size() == 0) {
            return Collections.emptyList();
        }
        return answer;
    }

    private static List<Integer> MoneyLoop(int money) {
        List<Integer> list = new ArrayList<>();
        List<Integer> moneyList = List.of(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1);

        moneyList.stream().reduce(money, (total, divMoney) -> {
            list.add(Math.floorDiv(total, divMoney));
            return Math.floorMod(total, divMoney);
        });
        return list;
    }
}
