package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {

    public static final int[] moneyUnitList = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();

        answer = new ArrayList<>();
        for(Integer moneyUnit : moneyUnitList) {
            answer.add(money / moneyUnit);
            money %= moneyUnit;
        }

        return answer;
    }
}
