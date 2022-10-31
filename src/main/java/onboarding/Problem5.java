package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        int[] moneyUnit = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

        if (money > 1000000 || money < 0)
            return answer;

        for (int unit : moneyUnit) {
            System.out.println(money / unit);
            answer.add((money / unit));
            money = money % unit;
        }

        return answer;
    }

}

