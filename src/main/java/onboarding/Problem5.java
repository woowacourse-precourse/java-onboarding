package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    private static int[] amounts = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
    private static int leftMoney;
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        leftMoney = money;

        for (int amount : amounts) {
            int count = calculateWithdraw(amount);
            answer.add(count);
        }
        return answer;
    }

    private static int calculateWithdraw(int amount) {
        int count = leftMoney / amount;
        leftMoney = leftMoney % amount;
        return count;
    }

}
