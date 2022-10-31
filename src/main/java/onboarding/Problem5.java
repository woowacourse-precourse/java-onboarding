package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        return getNumOfMoney(money);
    }

    private static List<Integer> getNumOfMoney(int money) {
        List<Integer> answer = new ArrayList<>();
        List<Integer> changeList = List.of(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1);

        for (Integer change : changeList) {
            answer.add(money / change);
            money %= change;
        }
        return answer;
    }
}
