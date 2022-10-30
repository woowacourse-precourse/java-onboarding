package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        if (!validation(money)) return Collections.emptyList();
        List<Integer> answer = new ArrayList<>(9);
        List<Integer> coins = List.of(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1);
        for (int coin : coins) {
            answer.add(money / coin);
            money %= coin;
        }
        return answer;
    }

    static boolean validation(int money) {
        return money > 0 && money <= 1000000;
    }
}
