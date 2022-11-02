package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List getCounts(int money) {
        List<Integer> moneyTypes = List.of(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1);
        List<Integer> result = new ArrayList<>();

        for (Integer moneyType : moneyTypes) {
            result.add(money / moneyType);
            money = money - moneyType * (money / moneyType);
        }

        return result;
    }

    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();

        answer = getCounts(money);

        return answer;
    }
}
