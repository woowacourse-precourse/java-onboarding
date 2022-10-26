package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        answer = convertAsList(money);
        return answer;
    }

    static List<Integer> convertAsList(int money) {
        List<Integer> bucksAndCoins = List.of(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1);
        List<Integer> answer = new ArrayList<>();
        for (Integer i : bucksAndCoins) {
            if (money / i > 0) {
                answer.add(money / i);
                money %= i;
            } else {
                answer.add(0);
            }
        }
        return answer;
    }
}
