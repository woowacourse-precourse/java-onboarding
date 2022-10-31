package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    static final int[] amount = {50_000, 10000, 5_000, 1_000, 500, 100, 50, 10, 1};
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>(Collections.emptyList());
        // Greedy algo
        for(int i=0;i< amount.length;i++){
            answer.add((Integer) money/amount[i]);
            money %= amount[i];
        }

        // answer check
        if(money != 0) throw new RuntimeException("Not Expected answer");

        return answer;
    }
}
