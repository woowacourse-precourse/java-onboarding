package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    static List<Integer> moneyUnitList = List.of(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1);
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        for (int moneyUnit : moneyUnitList) {
            int count = money / moneyUnit;
            answer.add(count);
            money -= moneyUnit * count;
        }
        return answer;
    }
}
