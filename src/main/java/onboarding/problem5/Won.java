package onboarding.problem5;

public enum Won {
    FIFTY_THOUSAND_WON(50_000),
    TEN_THOUSAND_WON(10_000),
    FIVE_THOUSAND_WON(5_000),
    ONE_THOUSAND_WON(1_000),
    FIVE_HUNDRED_WON(500),
    ONE_HUNDRED_WON(100),
    FIFTY_WON(50),
    TEN_WON(10),
    ONE_WON(1);

    private final int money;

    Won(int money) {
        this.money = money;
    }

    public int getMoney() {
        return this.money;
    }
}
