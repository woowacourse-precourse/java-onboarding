package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    private final static int[] MONETARY_UNITS = {50_000, 10_000, 5_000, 1_000, 500, 100, 50, 10, 1};

    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        for (int unit : MONETARY_UNITS) {
            int count = money / unit;
            answer.add(count);
            money %= unit;
        }
        return answer;
    }
}
