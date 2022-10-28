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

    public void increaseNumberOfBill(List<Integer> currentBillsSorted, Integer increasement) {
        for (int i = 0; i < currentBillsSorted.size(); i++) {
            Integer currentNumberOfBill = currentBillsSorted.get(i);
            currentNumberOfBill += increasement;
            currentBillsSorted.set(i, currentNumberOfBill);
        }
    }

    public Integer calculateNumberOfBillFromMoney(Integer currencyUnit, int money) {
        Integer numberOfBill = money / currencyUnit;
        return numberOfBill;
    }
}
