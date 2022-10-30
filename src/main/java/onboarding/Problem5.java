package onboarding;

import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        return answer;
    }
    private static Integer getCoinCount(int money, int cost) {
        int coinCounter = money / cost;
        return Integer.valueOf(coinCounter);
    }
}
