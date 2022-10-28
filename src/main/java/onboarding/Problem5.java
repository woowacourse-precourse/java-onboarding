package onboarding;

import onboarding.enums.CashType;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {

    private static final List<CashType> cashTypes = List.of(
            CashType.MONEY_50000,
            CashType.MONEY_10000,
            CashType.MONEY_5000,
            CashType.MONEY_1000,
            CashType.MONEY_500,
            CashType.MONEY_100,
            CashType.MONEY_50,
            CashType.MONEY_10,
            CashType.MONEY_1
    );

    public static List<Integer> solution(int money) {

        if (money < 1 || money > 1_000_000) {
            throw new IllegalArgumentException();
        }

        List<Integer> answer = new ArrayList<>();

        for (CashType cashType : cashTypes) {
            int amount = cashType.getAmount();

            answer.add(money / amount);
            money %= amount;
        }

        return answer;
    }
}
