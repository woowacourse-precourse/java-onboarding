package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    private static final Integer[] moneyUnits = new Integer[]{50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();

        for (Integer moneyUnit : moneyUnits) {
            if (money >= moneyUnit) {
                answer.add(money / moneyUnit);
                money = money % moneyUnit;
            } else {
                answer.add(0);
            }
        }

        return answer;
    }
}
