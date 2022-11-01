package onboarding;

import onboarding.problem5.MoneyType;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        validate(money);
        List<Integer> wallet = new ArrayList<>();
        calculateChanges(money, wallet);
        return wallet;
    }

    private static void validate(int money) {
        if (money < 1 || money > 1_000_000) {
            throw new IllegalArgumentException("유효하지 않은 금액입니다.");
        }
    }

    private static void calculateChanges(int money, List<Integer> wallet) {
        for (MoneyType value : MoneyType.VALUES) {
            wallet.add(money / value.getType());
            money %= value.getType();
        }
    }
}
