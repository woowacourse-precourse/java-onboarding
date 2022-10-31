package onboarding.problem5;

import java.util.List;

public class CurrencyDto {
    List<Integer> currencyList;

    public CurrencyDto(List<Integer> currencyList) {
        this.currencyList = currencyList;
    }

    public List<Integer> toList() {
        return currencyList;
    }
}
