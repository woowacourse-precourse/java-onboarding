package onboarding;

import java.util.ArrayList;
import java.util.List;

public class MoneyExchanger {
    private List<Integer> numberOfUnits = new ArrayList<>();

    public List<Integer> toUnits(int moneyToExchange) {
        toCoins(toBills(moneyToExchange));

        return numberOfUnits;
    }

    private int toBills(int moneyToExchange) {
        int countOfBills;
        int[] bills = {50000, 10000, 5000, 1000};

        for (int i = 0; i < bills.length; i++) {
            countOfBills = moneyToExchange / bills[i];
            numberOfUnits.add(countOfBills);
            moneyToExchange -= countOfBills * bills[i];
        }

        return moneyToExchange;
    }

    private void toCoins(int moneyToExchange) {
        int countOfCoins;
        int[] coins = {500, 100, 50, 10, 1};

        for (int i = 0; i < coins.length; i++) {
            countOfCoins = moneyToExchange / coins[i];
            numberOfUnits.add(countOfCoins);
            moneyToExchange -= countOfCoins * coins[i];
        }
    }
}
