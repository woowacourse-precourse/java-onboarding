package onboarding.problem5;

import java.util.List;

public class ValidationMoney {

    public static void validateMoney(int money) {
        final int MIN_VALUE = 1;
        final int MAX_VALUE = 1_000_000;

        if (money < MIN_VALUE || MAX_VALUE < money) {
            throw new IllegalArgumentException("금액은 1원 이상 100만원 이하여야 합니다.");
        }
    }
}
