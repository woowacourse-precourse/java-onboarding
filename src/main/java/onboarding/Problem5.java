package onboarding;

import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int account) {

        List<Integer> currencyInATM = List.of(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1);

        return withdrawCurrencyFromATM(currencyInATM, account);
    }

    private static List<Integer> withdrawCurrencyFromATM(List<Integer> currencyInATM, int account) {
        return null;
    }
}
