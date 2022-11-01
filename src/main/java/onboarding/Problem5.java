package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int account) {

        List<Integer> currencyInATM = List.of(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1);

        return withdrawCurrencyFromATM(currencyInATM, account);
    }

    private static List<Integer> withdrawCurrencyFromATM(List<Integer> currencyList, int account) {
        List<Integer> currencyToGive = new ArrayList<>();

        for (Integer currency : currencyList) {
            account = getMaxCurrencyFromAccountMoney(currencyToGive, currency, account);
        }

        return currencyToGive;
    }

    private static Integer getMaxCurrencyFromAccountMoney(List<Integer> currencyToGive, Integer currency, int account) {

    }
}
