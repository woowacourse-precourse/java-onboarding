package onboarding.problem5;

import static onboarding.problem5.ConstantsP5.MAX_MONEY;
import static onboarding.problem5.ConstantsP5.MIN_MONEY;

public class Money {
    private final int amount;

    public Money(int amount) {
        this.amount = amount;
        isIllegal();
    }

    private void isIllegal() {
        isInRange();
    }

    private void isInRange() {
        if (amount < MIN_MONEY || amount > MAX_MONEY) {
            throw new IllegalArgumentException();
        }
    }

    public int getAmount() {
        return amount;
    }
}
