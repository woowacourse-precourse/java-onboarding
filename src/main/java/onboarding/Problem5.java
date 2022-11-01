package onboarding;

import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        int[] unit = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
        for (int j : unit) {
            answer.add(money / j);
            money %= j;
        }
        return answer;
    }
}
