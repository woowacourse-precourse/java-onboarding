package onboarding.prob5.domain;

public enum Coin {

    fiftyThousand(50_000),
    tenThousand(10_000),
    fiveThousand(5_000),
    thousand(1_000),
    fiveHundred(500),
    Hundred(100),
    fifty(50),
    ten(10),
    one(1);

    public int getValue() {
        return value;
    }

    private final int value;

    Coin(int value) {
        this.value = value;
    }
}
