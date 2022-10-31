package onboarding.problem5;

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
        if (amount <= 0 || amount > 1000000) {
            throw new IllegalArgumentException();
        }
    }

    public int getAmount() {
        return amount;
    }
}
