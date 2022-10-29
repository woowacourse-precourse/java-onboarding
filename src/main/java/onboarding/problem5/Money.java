package onboarding.problem5;

public enum Money {
    FIVE_MILLION_WON(50000),
    TEN_THOUSAND_WON(10000),
    FIVE_THOUSAND_WON(5000),
    ONE_THOUSAND_WON(1000),
    FIVE_HUNDRED_WON(500),
    ONE_HUNDRED_WON(100),
    FIFTY_WON(50),
    TEN_WON(10),
    ONE_WON(1);

    private final int value;

    Money(int value) {
        this.value = value;
    }

    public int value() {
        return value;
    }
}
