package onboarding;

import java.util.LinkedList;
import java.util.List;

public class Problem5 {

    static final int[] moneyUnits = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

    public static List<Integer> solution(int money) {
        List<Integer> answer = new LinkedList<>();
        for (int i = 0; i < moneyUnits.length; i++) {
            answer.add(money / moneyUnits[i]);
            money %= moneyUnits[i];
        }
        return answer;
    }
}
