package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    public static final int[] MONEY_UNIT_LIST = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        for (int unit : MONEY_UNIT_LIST) {
            answer.add(money / unit);
            money %= unit;
        }
        return answer;
    }
}
