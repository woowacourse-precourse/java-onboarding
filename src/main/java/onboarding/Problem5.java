package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> moneys = List.of(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1);
        List<Integer> answer = new ArrayList<>();
        for (Integer integer : moneys) {
            answer.add(money / integer);
            money = money % integer;
        }

        return answer;
    }
}
