package onboarding.feature5;

import static onboarding.feature5.Constants.*;

import java.util.ArrayList;
import java.util.List;

public class MoneySorter {
    private int money = 0;
    private List<Integer> billsSorted;
    private int numberOfBill = 0;

    public MoneySorter(int money) {
        this.money = money;
        for (int i = 0; i < CURRENCY_UNIT.size(); i++) {
            billsSorted.add(numberOfBill);
        }
    }
    public static void increaseNumberOfBill(List<Integer> billsSorted, Integer increasement) {
        for (int i = 0; i < billsSorted.size(); i++) {
            Integer currentNumberOfBill = billsSorted.get(i);
            currentNumberOfBill += increasement;
            billsSorted.set(i, currentNumberOfBill);
        }
    }

    public static Integer getNumberOfBill(Integer currencyUnit, int givenMoney) {
        Integer numberOfBill = givenMoney / currencyUnit;
        return numberOfBill;
    }
}
