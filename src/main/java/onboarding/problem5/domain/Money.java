package onboarding.problem5.domain;

import java.util.ArrayList;
import java.util.List;

public class Money {
    private int money;
    
    public Money(final int money) {
        this.money = money;
    }
    
    public List<Integer> numberOfEachCurrency() {
        List<Integer> numberOfEachCurrency = new ArrayList<>();
        for (MonetaryUnits monetaryUnits : MonetaryUnits.values()) {
            numberOfEachCurrency.add(monetaryUnits.divide(money));
            money = monetaryUnits.remainder(money);
        }
        
        return numberOfEachCurrency;
    }
}
