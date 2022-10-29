package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        int[] won = {50000, 10000, 5000, 1000, 500, 50, 10, 1};
        for (int i = 0; i < won.length; i++) {
            int now = money / won[i];
            answer.add(now);
            money %= won[i];
        }
        return answer;
    }
}
