package onboarding.feature5;

import java.util.List;

public class MoneySorter {
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
