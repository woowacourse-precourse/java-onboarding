package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        final int[] unit = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
        List<Integer> answer = new ArrayList<>();

        for (int i = 0; i < unit.length; i++) {
            int k = money / unit[i];
            answer.add(k);
            money %= unit[i];
        }
        return answer;
    }
}
