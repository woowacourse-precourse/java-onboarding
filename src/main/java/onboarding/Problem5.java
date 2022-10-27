package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    private static final List<Integer> moneyTypes = List.of(50_000, 10_000, 5_000, 1_000, 500, 100, 50, 10, 1);

    public static List<Integer> solution(int money) {
        return convertMoney(money);
    }

    private static List<Integer> convertMoney(int money) {
        List<Integer> answer = new ArrayList<>();

        for (Integer moneyType : moneyTypes) {
            int moneyCount = 0;

            moneyCount += money / moneyType;
            money %= moneyType;

            answer.add(moneyCount);
        }
        return answer;
    }
}
