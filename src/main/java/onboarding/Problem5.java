package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> moneyList = new ArrayList<>(List.of(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1));

        int money_temp = money;
        List<Integer> answer = new ArrayList<Integer>();
        for (Integer m : moneyList) {
            answer.add(money_temp / m);
            money_temp %= m;
        }

        return answer;
    }
}
