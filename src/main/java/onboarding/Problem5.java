package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    private static final int[] MONEY_TYPE = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>(MONEY_TYPE.length);

        for (int i = 0; i < MONEY_TYPE.length; ++i) {
            int count = 0;
            while (money >= MONEY_TYPE[i]) {
                money -= MONEY_TYPE[i];
                ++count;
            }

            answer.add(Integer.valueOf(count));
        }

        return answer;
    }
}
