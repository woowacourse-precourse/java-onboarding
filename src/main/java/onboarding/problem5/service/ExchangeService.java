package onboarding.problem5.service;

import onboarding.problem5.domain.CurrencyExchangeStrategy;

import java.util.List;

public class ExchangeService {

    private final CurrencyExchangeStrategy currencyExchangeStrategy;

    public ExchangeService(CurrencyExchangeStrategy currencyExchangeStrategy) {
        this.currencyExchangeStrategy = currencyExchangeStrategy;
    }

    public List<Integer> exchange(int money) {
        return currencyExchangeStrategy.exchange(money);
    }
}
