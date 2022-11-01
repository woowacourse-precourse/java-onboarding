package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();

        List<Integer> coin = List.of(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1);
        List<Integer> cnt = new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0, 0));

        answer = withdraw(coin, cnt, money);
        return answer;
    }

    private static List<Integer> withdraw(List<Integer> coin, List<Integer> cnt, int money) {
        for (int i=0; i<coin.size(); i++) {
            if (money >= coin.get(i)) {
                cnt.set(i, money/coin.get(i));
                money %= coin.get(i);
            }
        }
        return cnt;
    }
}
