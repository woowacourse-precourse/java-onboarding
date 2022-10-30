package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    private static final List<Integer> moneyTypes = List.of(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1);

    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        for (int moneyType : moneyTypes) {
            answer.add(money / moneyType);
            money = money % moneyType;
        }
        return answer;
    }
}
