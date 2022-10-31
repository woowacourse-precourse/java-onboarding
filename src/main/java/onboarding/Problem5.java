package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    private static final int[] change =  {50_000, 10_000, 5_000, 1_000, 500, 100, 50, 10, 1};

    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        exchange(answer, money);
        return answer;
    }

    private static void exchange(List<Integer> answer, int money) {
        for(int i = 0; i < 9; i++) {
            answer.add(money / change[i]);
            money %= change[i];
        }
    }
}
