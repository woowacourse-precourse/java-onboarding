package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();

        List<Integer> temp = new ArrayList<>();
        List<Integer> moneyTypes = makeMoneyTypes();

        return answer;
    }

    static List<Integer> makeMoneyTypes() {
        return List.of(50_000, 10_000, 5_000, 1_000, 500, 100, 50, 10, 1);
    }
}
