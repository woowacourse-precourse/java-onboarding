package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    public static void withdrawMoney(int balance, List<Integer> answer) {
        final int[] units = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
        for (int i = 0; i < units.length; i++) {
            while (balance - units[i] >= 0) {
                answer.set(i, answer.get(i) + 1);
                balance -= units[i];
            }
        }
    }
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>(List.of(0, 0, 0, 0, 0, 0, 0, 0, 0));
        withdrawMoney(money, answer);
        return answer;
    }
}
