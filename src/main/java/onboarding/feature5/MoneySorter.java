package onboarding.feature5;

import static onboarding.feature5.Constants.*;

import java.util.ArrayList;
import java.util.List;

public class MoneySorter {
    private int money;
    private List<Integer> currentBillsSorted = new ArrayList<>();
    private int initialNumberOfBill = 0;

    public MoneySorter(int money) {
        this.money = money;
        for (int i = 0; i< CURRENCY_UNIT.size(); i++) {
            currentBillsSorted.add(initialNumberOfBill);
        }
    }

    public List<Integer> calculateNumberOfBills() {
        for (int i = 0; i < currentBillsSorted.size(); i++) {
            Integer currentCurrencyUnit = CURRENCY_UNIT.get(i);
            Integer currentNumberOfBill = currentBillsSorted.get(i);
            Integer increasedNumberOfBill = increaseNumberOfBill(currentCurrencyUnit, currentNumberOfBill);
            currentNumberOfBill += increasedNumberOfBill;
            currentBillsSorted.set(i, currentNumberOfBill);
        }
        return currentBillsSorted;
    }

    public Integer increaseNumberOfBill(Integer currencyUnit, Integer numberOfBill) {
        if (money >= currencyUnit) {
            Integer quotient = money / currencyUnit;
            numberOfBill += quotient;
            money -= currencyUnit * quotient;
            return numberOfBill;
        }
        return numberOfBill;
    }
}
