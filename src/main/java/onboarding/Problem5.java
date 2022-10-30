package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    private static final List<Integer> cashList = new ArrayList<>(List.of(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1));
    
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        return answer;
    }

    public static List<Integer> countCash(int money) {
        List<Integer> cashCount = new ArrayList<>();
        for (int cash : cashList) {
            cashCount.add(money / cash);
            money %= cash;
        }
        return cashCount;
    }
}
