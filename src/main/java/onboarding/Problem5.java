package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    public static final int[] AMOUNT = new int[]{50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

    public static List<Integer> solution(int money) {
        List<Integer> result = new ArrayList<>();

        int leftOver = money;
        for (int index = 0; index < AMOUNT.length; index++) {
            int divisor = AMOUNT[index];
            int quotient = leftOver / divisor;

            result.add(quotient);
            leftOver -= quotient * divisor;
        }

        return result;
    }
}
