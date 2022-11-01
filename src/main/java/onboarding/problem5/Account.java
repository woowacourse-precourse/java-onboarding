package onboarding.problem5;

public class Account {

    private final int MIN_MONEY = 1;
    private final int MAX_MONEY = 1_000_000;

    private int money;

    public Account(int money) {
        validateMoney(money);
        this.money = money;
    }

    private void validateMoney(int money) {
        if (isOutOfBounds(money)) throw new IllegalArgumentException("money is out of bounds");
    }

    private boolean isOutOfBounds(int money) {
        return money < MIN_MONEY || money > MAX_MONEY;
    }

}
