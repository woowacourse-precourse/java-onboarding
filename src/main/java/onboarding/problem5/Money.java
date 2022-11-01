package onboarding.problem5;

public enum Money {
    FIVE_MILLION(50_000),
    ONE_MILLION(10_000),
    FIVE_THOUSAND(5_000),
    ONE_THOUSAND(1_000),
    FIVE_HUNDRED(500),
    ONE_HUNDRED(100),
    FIFTY(50),
    TEN(10),
    ONE(1);

    private final int value;

    public int getIntValue() {
        return value;
    }

    Money(int value) {
        this.value = value;
    }
}
