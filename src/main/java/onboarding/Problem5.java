package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {

    private static final int DID_NOT_EXCHANGE_THIS_UNIT = 0;

    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        List<Integer> moneyUnits = List.of(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1);

        for (Integer moneyUnit : moneyUnits) {
            money = exchangeMoney(money, answer, moneyUnit);
        }
        return answer;
    }

    private static int exchangeMoney(int money, List<Integer> answer, int moneyUnit) {
        if (money < moneyUnit) {
            answer.add(DID_NOT_EXCHANGE_THIS_UNIT);
            return money;
        }

        answer.add(money / moneyUnit);
        money = money % moneyUnit;
        return money;
    }
}
