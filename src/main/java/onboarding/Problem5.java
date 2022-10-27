package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        List<Integer> bills = List.of(50_000, 10_000, 5_000, 1_000, 500, 100, 50, 10, 1);

        for (Integer bill : bills) {
            int x = money / bill;
            answer.add(x);
            money -= (bill * x);
        }

        return answer;
    }
}
