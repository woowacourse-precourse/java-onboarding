package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();

        answer = count(money);

        return answer;
    }

    private static List<Integer> count(int money) {
        List<Integer> result = new ArrayList<>();
        List<Integer> moneyUnit = Arrays.asList(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1);

        for (int i = 0; i < moneyUnit.size(); i++) {
            int currentUnit = moneyUnit.get(i);

            int cnt = money / currentUnit;
            money = money % currentUnit;

            result.add(cnt);
        }

        return result;
    }
}
