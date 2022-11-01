package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        List<Integer> units = List.of(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1);
        answer = new ArrayList<>();

        for (int unit : units) {
            money = exchange(answer, money, unit);
        }

        return answer;
    }

    public static int exchange(List<Integer> changes, int money, int unit) {
        int result = 0;

        changes.add(money / unit);
        result = money % unit;

        return result;
    }
}
