package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        int[] MoneyUnit = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
        for (int i = 0; i < 9; i++) {
            int change = money / MoneyUnit[i];
            answer.add(i, change);
            money -= (MoneyUnit[i] * change);
        }
        return answer;
    }

}
