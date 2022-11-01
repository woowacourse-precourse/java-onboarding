package onboarding.support.problem5;

public enum MoneyType {
    FIFTY_THOUSANDS(50000),
    TEN_THOUSANDS(10000),
    FIVE_THOUSANDS(5000),
    ONE_THOUSAND(1000),
    FIVE_HUNDREDS(500),
    ONE_HUNDRED(100),
    FIFTY(50),
    TEN(10),
    ONE(1);

    private final int money;

    MoneyType(int money) {
        this.money = money;
    }

    public int getMoney() {
        return money;
    }
}
