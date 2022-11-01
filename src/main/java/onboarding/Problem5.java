package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {

    public static List<Integer> solution(int money) {
        List<Integer> moneyUnit = List.of(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1);
        List<Integer> answer = new ArrayList<>(9);
        for (int change: moneyUnit) {
            answer.add(money / change);
            money %= change;
        }
        return answer;
    }
}
