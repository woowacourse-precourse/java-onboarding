package onboarding.problem5;

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
            10
    };
    private final int money;

    public CurrencyExchangerV1(int money){
        this.money = money;
    }

    @Override
    public List<Integer> exchange() {
        return null;
    }
}
