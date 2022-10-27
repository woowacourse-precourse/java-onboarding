package onboarding;

import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        return answer;
    }

    private static int getMoney(int money, int[] CoinUnit, int[] answerCount) {
        for (int i = 0; i < CoinUnit.length; i++) {
            if (money >= CoinUnit[i]) {
                money -= CoinUnit[i];
                answerCount[i]++;
                break;
            }
        }
        return money;
    }
}
