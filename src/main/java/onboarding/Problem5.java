package onboarding;

import onboarding.problem5.CurrencyExchanger;
import onboarding.problem5.CurrencyExchangerV1;

import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        CurrencyExchanger exchanger = new CurrencyExchangerV1();
        return exchanger.exchange(money);
    }
}
