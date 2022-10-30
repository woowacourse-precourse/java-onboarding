package onboarding.problem5;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

public class CurrencyExchanger {
    private final SortedSet<Integer> currencyUnits = new TreeSet<>(
            (currencyUnit1, currencyUnit2) -> -currencyUnit1.compareTo(currencyUnit2));

    public void addCurrencyUnit(int currencyUnit) {
        currencyUnits.add(currencyUnit);
    }

    public List<Integer> minNumCurrencyUnits(int money) {
        List<Integer> numCurrencyUnits = new ArrayList<>();
        for (var currencyUnit : currencyUnits) {
            int cnt = money / currencyUnit;
            money -= cnt * currencyUnit;
            numCurrencyUnits.add(cnt);
        }
        return numCurrencyUnits;
    }
}
