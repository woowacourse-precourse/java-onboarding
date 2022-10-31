package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {

    private static final int[] moneyArr = new int[] { 50000, 10000, 5000, 1000, 500, 100, 50, 10, 1 };

    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();

        countMoneyGreedy(money, answer);

        return answer;
    }

    private static void countMoneyGreedy(int money, List<Integer> answer) {
        int idx = 0;
        while (idx < moneyArr.length) {
            answer.add(money / moneyArr[idx]);
            money %= moneyArr[idx++];
        }
    }
}
