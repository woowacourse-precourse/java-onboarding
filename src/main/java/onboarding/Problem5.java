package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        int[] moneyArray = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
        List<Integer> answer = new ArrayList<>();

        for (int j : moneyArray) {
            answer.add(money / j);
            money %= j;
        }

        return answer;
    }
}
