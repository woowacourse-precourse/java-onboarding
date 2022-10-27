package onboarding.problem5;

import java.util.ArrayList;
import java.util.List;

public class CurrencyExchangerV1 implements CurrencyExchanger{
    private final int[] exchangePolicy = {
            50000,
            10000,
            5000,
            1000,
            500,
            100,
            50,
            10,
            1
    };

    @Override
    public List<Integer> exchange(int money) {
        List<Integer> currencyCountList = new ArrayList<>();
        for(int currency: exchangePolicy){
            currencyCountList.add(money / currency);
            money %= currency;
        }
        return currencyCountList;
    }
}
