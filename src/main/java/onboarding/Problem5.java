package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {

    private static final int[] bill = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

    public static List<Integer> solution(int money) {
        if (!isOutOfRange(money)) {
            return new ArrayList<>();
        }
        return calculate(money);
    }

    private static boolean isOutOfRange(int money) {
        return money >= 1 && money <= 1000000;
    }

    private static List<Integer> calculate(int money) {
        List<Integer> answer = new ArrayList<>();

        for (int i = 0; i < 9; i++) {
            answer.add(money / bill[i]);
            money %= bill[i];
        }

        return answer;
    }
}
