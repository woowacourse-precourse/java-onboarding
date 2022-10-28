package onboarding.problem5.vo;

public enum Change {
    FIFTY_THOUSANDS(0, 50_000),
    TEN_THOUSANDS(1, 10_000),
    FIVE_THOUSANDS(2, 5_000),
    THOUSAND(3, 1_000),
    FIVE_HUNDREDS(4, 500),
    HUNDRED(5, 100),
    FIFTY(6, 50),
    TEN(7, 10),
    ONE(8, 1),;

    private final int index;
    private final int value;

    Change(int index, int value) {
        this.index = index;
        this.value = value;
    }

    public int getIndex() {
        return index;
    }

    public int getValue() {
        return value;
    }
}
