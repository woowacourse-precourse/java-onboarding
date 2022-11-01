package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 기능 1: 가장 큰 금액 화폐부터 뽑도록 하는 기능 구현
 */
public class Problem5 {
    private static final int[] MONEY = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();

        for (int i = 0; i < MONEY.length; i++) {
            int count = money / MONEY[i];
            money %= MONEY[i];
            answer.add(count);
        }

        return answer;
    }
}
