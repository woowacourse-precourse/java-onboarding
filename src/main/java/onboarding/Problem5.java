package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {

    private static final int[] CURRENCYS_DESCENDING_ORDER = {50_000, 10_000, 5_000, 1_000, 500, 100, 50, 10, 1};

    public static List<Integer> solution(int money) {
        final int NUMBER_OF_CURRENCYS = CURRENCYS_DESCENDING_ORDER.length;
        List<Integer> numberByCurrency = new ArrayList<>(NUMBER_OF_CURRENCYS);

        for (int i = 0; i < NUMBER_OF_CURRENCYS; i++) {
            int currency = CURRENCYS_DESCENDING_ORDER[i];
            int numberOfCurrency = 0;

            while (Math.subtractExact(money, currency) >= 0) {
            }
        }

        return numberByCurrency;
    }
}
