package onboarding;

import java.util.ArrayList;
import java.util.List;

public class MoneyExchanger {
    private List<Integer> numberOfUnits = new ArrayList<>();
    private int moneyToExchange;

    public MoneyExchanger(int money) {
        this.moneyToExchange = money;
    }

    public List<Integer> toUnits() {
        toBills();
        toCoins();

        return numberOfUnits;
    }

    private void toBills() {
        int countOfBills;
        int[] bills = {50000, 10000, 5000, 1000};

        for (int i = 0; i < bills.length; i++) {
            countOfBills = moneyToExchange / bills[i];
            numberOfUnits.add(countOfBills);
            moneyToExchange -= countOfBills * bills[i];
        }
    }

    private void toCoins() {
        int countOfCoins;
        int[] coins = {500, 100, 50, 10, 1};

        for (int i = 0; i < coins.length; i++) {
            countOfCoins = moneyToExchange / coins[i];
            numberOfUnits.add(countOfCoins);
            moneyToExchange -= countOfCoins * coins[i];
        }
    }
}
