package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {

    private static final int DID_NOT_EXCHANGE_THIS_UNIT = 0;

    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        List<Integer> moneyUnitsToExchange = List.of(
                50_000, 10_000, 5_000,
                1_000, 500, 100,
                50, 10, 1
        );

        for (Integer moneyUnit : moneyUnitsToExchange) {
            money = exchangeMoney(money, moneyUnit, answer);
        }
        return answer;
    }

    private static int exchangeMoney(int money, int moneyUnit, List<Integer> answer) {
        if (money < moneyUnit) {
            answer.add(DID_NOT_EXCHANGE_THIS_UNIT);
            return money;
        }

        answer.add(money / moneyUnit);
        return money % moneyUnit;
    }
}
