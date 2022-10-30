package onboarding.problem5.domain;

import java.util.List;

public class Money {

    public static final Money FIFTY_THOUSAND = new Money(50_000);

    public static final Money TEN_THOUSAND = new Money(10_000);

    public static final Money FIVE_THOUSAND = new Money(5_000);

    public static final Money THOUSAND = new Money(1_000);

    public static final Money FIVE_HUNDRED = new Money(500);

    public static final Money HUNDRED = new Money(100);

    public static final Money FIFTY = new Money(50);

    public static final Money TEN = new Money(10);

    public static final Money ONE = new Money(1);

    public static final List<Money> DEFAULT_MONIES =
            List.of(FIFTY_THOUSAND, TEN_THOUSAND,
                    FIVE_THOUSAND, THOUSAND,
                    FIVE_HUNDRED, HUNDRED,
                    FIFTY, TEN, ONE);
    
    private final int amount;

    public Money(int amount) {
        this.amount = amount;
    }

    public int divide(Money money) {
        return this.amount / money.amount;
    }

    public Money remainder(Money money) {
        return new Money(this.amount % money.amount);
    }
}
