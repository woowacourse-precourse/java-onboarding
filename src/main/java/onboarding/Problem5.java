package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/*
가장 큰 화폐부터 나누고, 나눠지지 않는다면 0
 */
public class Problem5 {
    public static List<Integer> solution(int money) {
        ArrayList<Integer> answer = new ArrayList<>();
        final int[] moneyUnit = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
        int moneyUnitLen = moneyUnit.length;
        for (int i = 0; i < moneyUnitLen; ++i) {
            if (money >= moneyUnit[i]) {
                answer.add(money / moneyUnit[i]);
                money %= moneyUnit[i];
            }
            else
                answer.add(0);
        }
        return answer;
    }
}
