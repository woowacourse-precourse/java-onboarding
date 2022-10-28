package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        answer = new ArrayList<>();

        int[] separateMoney = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
        for (int i = 0; i < separateMoney.length; i++) {
            if (money >= 0) {
                int payCnt = 0;
                payCnt = money / separateMoney[i];
                answer.add(payCnt);
                money %= separateMoney[i];
            }
        }
        return answer;
    }
}