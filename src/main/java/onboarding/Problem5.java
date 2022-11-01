package onboarding;

import onboarding.enums.CashType;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {

    public static List<Integer> solution(int money) {

        if (money < 1 || money > 1_000_000) {
            throw new IllegalArgumentException();
        }

        List<Integer> answer = new ArrayList<>();

        for (CashType cashType : CashType.values()) {
            int amount = cashType.getAmount();

            answer.add(money / amount);
            money %= amount;
        }

        return answer;
    }
}
