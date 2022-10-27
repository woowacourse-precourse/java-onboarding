package onboarding.problem5.domain;

public enum MonetaryUnits {
    FIFTY_THOUSAND(50000),
    TEN_THOUSAND(10000);
    
    private final int monetaryUnit;
    
    MonetaryUnits(final int monetaryUnit) {
        this.monetaryUnit = monetaryUnit;
    }
    
    public int divide(final int money) {
        return money / monetaryUnit;
    }
}
