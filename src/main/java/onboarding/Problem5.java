package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {

    private static final int ZERO = 0;
    private static final int[] CURRENCY = {50_000, 10_000, 5_000, 1_000, 500, 100, 50, 10, 1};

    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>(List.of(ZERO, ZERO, ZERO, ZERO, ZERO, ZERO, ZERO, ZERO, ZERO));
        for (int index = ZERO; index < CURRENCY.length; index++) {
            answer.set(index, money / CURRENCY[index]);
            money %= CURRENCY[index];
        }
        return answer;
    }
}
