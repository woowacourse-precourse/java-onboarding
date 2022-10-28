package onboarding.feature5;

import static onboarding.feature5.Constants.*;

import java.util.ArrayList;
import java.util.List;

public class MoneySorter {
    private int money = 0;
    private List<Integer> currentBillsSorted = new ArrayList<>();
    private int numberOfBill = 0;

    public MoneySorter(int money) {
        this.money = money;
        for (int i = 0; i< CURRENCY_UNIT.size(); i++) {
            currentBillsSorted.add(numberOfBill);
        }
    }

    public List<Integer> calculateNumberOfBill() {
        for (int i = 0; i < currentBillsSorted.size(); i++) {
            Integer currentNumberOfBill = currentBillsSorted.get(i);
            Integer increasement = getNumberOfBillFromMoney(CURRENCY_UNIT.get(i));
            currentNumberOfBill += increasement;
            currentBillsSorted.set(i, currentNumberOfBill);
        }
        return currentBillsSorted;
    }

    public Integer getNumberOfBillFromMoney(Integer currencyUnit) {
        Integer numberOfBill = 0;
        if (money >= currencyUnit) {
            Integer quotient = money / currencyUnit;
            money -= quotient * currencyUnit;
            return numberOfBill += quotient;
        }
        return numberOfBill;
    }
}
