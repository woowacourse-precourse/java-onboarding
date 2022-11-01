package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {

    private final static int[] unit = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

    private static List<Integer> getMoneyList(int money) {
        List<Integer> answer = new ArrayList<>();
        for (int u : unit) {
            int count = money / u;
            answer.add(count);
            money %= u;
        }
        return answer;
    }

    public static List<Integer> solution(int money) {
        List<Integer> answer = getMoneyList(money);
        return answer;
    }
}
