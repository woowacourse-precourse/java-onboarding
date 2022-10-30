package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        // List<Integer> answer = Collections.emptyList();
        List<Integer> answer = new ArrayList<>();
        int[] moneys = { 50000, 10000, 5000, 1000, 500, 100, 50, 10, 1 };

        for (int i=0; i<moneys.length; i++) {
            if (money < moneys[i]) {
                answer.add(0);
                continue;
            }

            answer.add(money / moneys[i]);
            money -= (money / moneys[i]) * moneys[i];
        }

        return answer;
    }
}
