package onboarding;

import onboarding.problem5.Atm;
import onboarding.problem5.ChangesList;

import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        validateMoney(money);

        Atm atm = new Atm(new ChangesList());
        return atm.withdraw(money);
    }

    private static void validateMoney(int money) {
        final int MIN_VALUE = 1;
        final int MAX_VALUE = 1_000_000;

        if (money < MIN_VALUE || MAX_VALUE < money) {
            throw new IllegalArgumentException("금액은 1원 이상 100만원 이하여야 합니다.");
        }
    }
}
