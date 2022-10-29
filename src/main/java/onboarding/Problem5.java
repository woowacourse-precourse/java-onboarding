package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {

    static final int[] UNITS = {50_000, 10_000, 5_000, 1_000, 500, 100, 50, 10, 1};


    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();

        int leftMoney = money;

        for(int unit: UNITS) {
            if(leftMoney < unit) {
                answer.add(0);
                continue;
            }

            int unitCount = leftMoney / unit;
            answer.add(unitCount);

            leftMoney %= unit;
        }

        return answer;
    }
}
