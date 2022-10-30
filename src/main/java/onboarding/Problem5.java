package onboarding;

import onboarding.problem5.CurrencyExchanger;

import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        CurrencyExchanger currencyExchanger = new CurrencyExchanger();
        currencyExchanger.addCurrencyUnit(1);
        currencyExchanger.addCurrencyUnit(10);
        currencyExchanger.addCurrencyUnit(50);
        currencyExchanger.addCurrencyUnit(100);
        currencyExchanger.addCurrencyUnit(500);
        currencyExchanger.addCurrencyUnit(1_000);
        currencyExchanger.addCurrencyUnit(5_000);
        currencyExchanger.addCurrencyUnit(10_000);
        currencyExchanger.addCurrencyUnit(50_000);
        return currencyExchanger.minNumCurrencyUnits(money);
    }
}
