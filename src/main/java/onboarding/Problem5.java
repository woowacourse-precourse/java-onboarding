package onboarding;

import onboarding.problem5.domain.CurrencyExchangeStrategy;
import onboarding.problem5.domain.KoreanCurrencyExchangeStrategy;
import onboarding.problem5.service.ExchangeService;

import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        CurrencyExchangeStrategy currencyExchangeStrategy = new KoreanCurrencyExchangeStrategy();
        ExchangeService exchangeService = new ExchangeService(currencyExchangeStrategy);
        return exchangeService.exchange(money);
    }
}
