package onboarding.problem5;

public enum MoneyType {
    FIFTY_THOUSAND(50_000),
    TEN_THOUSAND(10_000),
    FIVE_THOUSAND(5_000),
    ONE_THOUSAND(1_000),
    FIVE_HUNDRED(500),
    ONE_HUNDRED(100),
    FIFTY(50),
    TEN(10),
    ONE(1);

    public static final MoneyType[] VALUES = values();
    private final int type;

    MoneyType(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }
}
