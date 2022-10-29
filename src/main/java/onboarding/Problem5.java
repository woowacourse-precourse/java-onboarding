package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        int[] unitChange = new int[] {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

        if (!verifyException(money)) {
            return Collections.emptyList();
        }
        return exchangeChange(money, unitChange);
    }

    private static List<Integer> exchangeChange(int money, int[] unitChange) {
        List<Integer> answer = new ArrayList<Integer>();

        for (int i = 0; i < unitChange.length; i++){
            answer.add(money / unitChange[i]);
            money %= unitChange[i];
        }
        return answer;
    }

    private static boolean verifyException(int money) {
        return (money >= 1 && money <=  1_000_000);
    }
}
