package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    private static final Integer[] UNITS = {50_000, 10_000, 5_000, 1_000, 500, 100, 50, 10, 1};

    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        for (Integer unit : UNITS) {
            answer.add(money / unit);
            money %= unit;
        }
        return answer;
    }
}
