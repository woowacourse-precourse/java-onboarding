package onboarding;

import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        int coins[] = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 5, 1};

        for(int i = 0; i < 10; i++) {
            answer.add(money / coins[i]);
            money %= coins[i];
        }

        return answer;
    }
}
