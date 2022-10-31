package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {

    private static final int[] CURRENCY = {50_000, 10_000, 5_000, 1_000, 500, 100, 50, 10, 1};

    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        while (money > 0) {
            for (int unit : CURRENCY) {
                if (money >= unit) {
                    answer.add(money / unit);
                    money = money % unit;
                    continue;
                }
                answer.add(0);
            }
        }
        return answer;
    }
}
