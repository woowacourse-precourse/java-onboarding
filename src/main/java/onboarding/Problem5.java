package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        return exchangeMoney(money);
    }

    public static List<Integer> exchangeMoney(int money) {
        List<Integer> answer = new ArrayList<>();
        int[] cash = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

        for (int i = 0; i < cash.length; i++) {
            if (money >= cash[i]) {
                answer.add(money / cash[i]);
                money -= cash[i] * answer.get(i);
            } else answer.add(0);
        }

        return answer;
    }
}
