package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();

        if (throwBoundaryException(money)) {
            return answer;
        }

        answer.add(calculateFiftyThousand(money));
        money -= 50_000 * answer.get(0);

        answer.add(calculateTenThousand(money));
        money -= 10_000 * answer.get(1);

        answer.add(calculateFiveThousand(money));
        money -= 5_000 * answer.get(2);

        answer.add(calculateOneThousand(money));
        money -= 1_000 * answer.get(3);

        answer.add(calculateFiveHundred(money));
        money -= 500 * answer.get(4);

        return answer;
    }

    public static boolean throwBoundaryException(int money) {
        return money < 1 || money > 1_000_000;
    }

    public static int calculateFiftyThousand(int money) {
        return money / 50000;
    }

    public static int calculateTenThousand(int money) {
        return money / 10_000;
    }

    public static int calculateFiveThousand(int money) {
        return money / 5_000;
    }

    public static int calculateOneThousand(int money) {
        return money/ 1_000;
    }

    public static int calculateFiveHundred(int money) {
        return money / 500;
    }

}
