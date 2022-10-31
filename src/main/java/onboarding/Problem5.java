package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();

        answer = new ArrayList<>();

        int[] exchangeCount = calc(money);

        for (int i = 0; i < exchangeCount.length; i++) {
            answer.add(exchangeCount[i]);
        }

        return answer;
    }

    public static int[] calc(int money) {
        int[] exchange = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
        int[] count = new int[exchange.length];

        for (int i = 0; i < exchange.length; i++) {
            count[i] = money / exchange[i];
            money %= exchange[i];
        }

        return count;
    }
}
