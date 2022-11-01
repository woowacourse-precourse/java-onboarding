package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();

        // 돈 종류
        List<Integer> money_types = List.of(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1);

        // 큰 돈 부터 나눠가면서 몫을 구해가면 된다.
        for (int money_type : money_types) {
            int quotient = money / money_type;
            answer.add(quotient);

            money %= money_type;
        }

        return answer;
    }
}
