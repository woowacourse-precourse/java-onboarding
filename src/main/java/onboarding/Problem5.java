package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        if (money < 1 || money > 1000000)
            return answer;
        List<Integer> amounts = List.of(50000, 10000, 5000, 1000, 500, 100, 50 , 10, 1);
        for (int amount : amounts) {
            int count = money / amount;
            answer.add(count);
            money %= amount;
        }
        return answer;
    }
}
