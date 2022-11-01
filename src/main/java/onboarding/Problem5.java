package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    private static List<Integer> result = new ArrayList<>();
    private static List<Integer> coins= List.of(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1);

    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        return MoneyNumber(money);
    }
}
