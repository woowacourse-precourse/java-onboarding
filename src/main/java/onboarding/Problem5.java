package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    private static final int[] UNITS = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

    public static List<Integer> solution(int money) {
        return getAllCntByUnit(money);
    }

    private static List<Integer> getAllCntByUnit(int money) {
        List<Integer> answer = new ArrayList<>();
        for (int unit : UNITS) {
            answer.add(money / unit);
            money %= unit;
        }
        return answer;
    }
}
