package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem5 {

    private final static List<Integer> moneyUnitList = Arrays.asList(
            50000, 10000, 5000, 1000, 500, 100, 50, 10, 1
    );
    
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        for (int unit : moneyUnitList) {
            answer.add(money / unit);
            money %= unit;
        }
        return answer;
    }
}
