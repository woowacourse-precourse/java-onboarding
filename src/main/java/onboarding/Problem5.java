package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();

        answer = new ArrayList<Integer>();

        int[] coins = {50000, 10000, 5000, 1000, 500, 100, 50 ,10, 1};

        for (int coin: coins) {
            int count = 0;

            count += money/coin;

            money = money % coin;

            answer.add(count);
        }

        return answer;
    }
}
