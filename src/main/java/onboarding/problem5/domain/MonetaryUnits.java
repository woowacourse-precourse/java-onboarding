package onboarding.problem5.domain;

public enum MonetaryUnits {
    FIFTY_THOUSAND(50000),
    TEN_THOUSAND(10000),
    FIVE_THOUSAND(5000),
    ONE_THOUSAND(1000),
    FIVE_HUNDRED(500),
    ONE_HUNDRED(100),
    FIFTY(50);
    
    private final int monetaryUnit;
    
    MonetaryUnits(final int monetaryUnit) {
        this.monetaryUnit = monetaryUnit;
    }
    
    public int divide(final int money) {
        return money / monetaryUnit;
    }
}
