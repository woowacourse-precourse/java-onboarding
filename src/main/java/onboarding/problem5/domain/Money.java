package onboarding.problem5.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Money {
    private int money;
    
    public Money(final int money) {
        this.money = money;
    }
    
    public List<Integer> numberOfEachCurrency() {
        return Arrays.stream(MonetaryUnits.values())
                .map(this::numberOfCurrentCurrency)
                .collect(Collectors.toList());
    }
    
    private int numberOfCurrentCurrency(final MonetaryUnits monetaryUnit) {
        final int divideNumber = monetaryUnit.divide(money);
        money = monetaryUnit.remainder(money);
        return divideNumber;
    }
}
