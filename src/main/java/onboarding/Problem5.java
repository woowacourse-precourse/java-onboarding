package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        answer = getChange(money);

        return answer;
    }

    static List<Integer> getChange(int money) {

        List<Integer> answer = new ArrayList<>();
        List<Integer> ml = List.of(50000, 10000, 5000, 1000, 500, 100, 50, 10);
        for (Integer integer : ml) {
            int change;

            change = money / integer;
            answer.add(change);
            money = money % integer;
        }
        answer.add(money);

        return answer;
    }
}
