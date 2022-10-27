package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = makeList(money);
        return answer;
    }

    private static List<Integer> makeList(int money) {
        List<Integer> resultList = new ArrayList<>();
        int[] moneyList = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
        for (int i: moneyList) {
            int quotient = money / i;
            money -= quotient * i;
            resultList.add(quotient);
        }
        return resultList;
    }
}
