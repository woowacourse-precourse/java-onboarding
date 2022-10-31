package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> monetaryUnit = List.of(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1);
        List<Integer> answer = new ArrayList<>();
        for (Integer unit : monetaryUnit) {
            answer.add(money/unit);
            money = money - (money/unit) * unit;
        }
        return answer;
    }
}
