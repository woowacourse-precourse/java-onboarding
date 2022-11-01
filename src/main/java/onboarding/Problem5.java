package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    public static final int[] MONEYTARY_UNITS = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

    public static List<Integer> solution(int money) {
        return convertMoneyIntoCurrencies(money);
    }

    private static List<Integer> convertMoneyIntoCurrencies(int money) {
        List<Integer> convertedCurrencies = new ArrayList<>();
        for (int moneytaryUnit : MONEYTARY_UNITS) {
            int convertedCount = getConvertedCount(money, moneytaryUnit);
            money -= getConvertedTotal(moneytaryUnit, convertedCount);
            convertedCurrencies.add(convertedCount);
        }
        return convertedCurrencies;
    }

    private static int getConvertedTotal(int moneytaryUnit, int convertedCount) {
        return convertedCount * moneytaryUnit;
    }

    private static int getConvertedCount(int money, int moneytaryUnit) {
        return money / moneytaryUnit;
    }
}
