package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        return answer;
    }

    
    private static List<Integer> changeMoney(int money) {
        List<Integer> answer = new ArrayList<>();
        List<Integer> bills = List.of(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1);

        for (int i = 0; i < bills.size(); i++) {
            answer.add(money / bills.get(i));
            money %= bills.get(i);
        }

        return answer;
    }
}
