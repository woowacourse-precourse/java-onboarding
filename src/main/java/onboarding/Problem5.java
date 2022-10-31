package onboarding;

import java.util.ArrayList;
import java.util.List;


public class Problem5 {
    private static final List<Integer> units = List.of(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1);

    public static List<Integer> solution(int money) {
       return findAllCntByMoneyUnit(money);
    }

    private static List<Integer> findAllCntByMoneyUnit(int money) {
        List<Integer> answer = new ArrayList<>();
        for (int unit : units) {
            int cnt = money / unit;
            answer.add(cnt);
            money %= unit;
        }
        return answer;
    }
}
