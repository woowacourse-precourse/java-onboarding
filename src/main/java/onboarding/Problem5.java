package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0, 0);
        int[] ref = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

        int idx = 0;
        while (money > 0) {
            answer.set(idx, answer.get(idx) + money/ref[idx]);
            money %= ref[idx++];
        }

        return answer;
    }
}
