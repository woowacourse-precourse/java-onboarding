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

        return answer;
    }

    public static boolean throwBoundaryException(int money) {
        return money < 1 || money > 1000000;
    }

    public static int calculateFiftyThousand(int money) {
        return money / 50000;
    }

}
