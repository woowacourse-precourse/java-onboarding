package onboarding.feature5;

import java.util.List;

public class MoneySorter {
    public static void increaseNumberOfBill(List<Integer> bills, Integer increasement) {
        for (int i = 0; i < bills.size(); i++) {
            Integer currentNumberOfBill = bills.get(i);
            currentNumberOfBill += increasement;
            bills.set(i, currentNumberOfBill);
        }
    }

    public static Integer getNumberOfBill(Integer currencyUnit, int givenMoney) {
        Integer numberOfBill = givenMoney / currencyUnit;
        return numberOfBill;
    }
}
