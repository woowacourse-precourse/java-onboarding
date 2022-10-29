package onboarding.problem5;

import java.util.Arrays;
import java.util.List;

public class Bank {
    private final static int[] monetaryUnit = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
    private final static int NUMBER_OF_MONETARY_UNIT = 9;

    public List<Integer> convertMoneyToMonetaryUnit(int money) {
        List<Integer> withdrawMoneyList = Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0, 0);
        int countMonetaryUnit = 0;

        for (int i = 0; i < NUMBER_OF_MONETARY_UNIT; i++) {
            countMonetaryUnit = money / monetaryUnit[i];
            money -= countMonetaryUnit * monetaryUnit[i];
            withdrawMoneyList.set(i, countMonetaryUnit);
        }
        return withdrawMoneyList;
    }
}
