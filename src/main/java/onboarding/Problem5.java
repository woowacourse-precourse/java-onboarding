package onboarding;

import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> moneyList = List.of(
            50000, 10000, 5000, 1000, 500, 100, 50, 10, 1
    );

    public static List<Integer> solution(int money) {
        List<Integer> answer = new java.util.ArrayList<>(Collections.emptyList());
        for (Integer divisorMoney : moneyList) {
            answer.add(money / divisorMoney);
            money %= divisorMoney;
        }
        return answer;
    }
}
