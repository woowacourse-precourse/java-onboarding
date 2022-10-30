package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    private static int[] cash_type = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i <9; i++) {
            answer.add(money/cash_type[i]);
            money %= cash_type[i];
        }
        return answer;
    }
}
