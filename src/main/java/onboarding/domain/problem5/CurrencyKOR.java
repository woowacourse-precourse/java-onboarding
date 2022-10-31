package onboarding.domain.problem5;

public enum CurrencyKOR {
    FiftyThousand(50000),
    TenThousand(10000),
    FiveThousand(5000),
    Thousand(1000),
    FiveHundred(500),
    Hundred(100),
    Fifty(50),
    Ten(10),
    One(1);

    private final int money;
    CurrencyKOR(int money) {
        this.money = money;
    }
    public int getChange(int pay) {
        return pay%money;
    };
    public int calculate(int pay) {
        return pay/money;
    }
}
