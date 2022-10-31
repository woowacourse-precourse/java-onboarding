package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = getAnswer(money);

        return answer;
    }

    private static List<Integer> getAnswer(int money) {
        List<Integer> answer = new ArrayList<>();
        int[] bills = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

        for (int bill : bills) {
            if (money >= bill) {
                answer.add(money / bill);
                money %= bill;
            }
            else
                answer.add(0);
        }
        return answer;
    }
}
