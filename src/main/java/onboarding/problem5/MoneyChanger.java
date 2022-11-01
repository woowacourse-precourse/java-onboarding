package onboarding.problem5;

import java.util.Arrays;
import java.util.List;

public class MoneyChanger {
    private static final int NUMBER_OF_CURRENCY_TYPE = 9;
    private final InputNumberValidator inputNumberValidator = new InputNumberValidator();

    public List<Integer> change(int money) {
        inputNumberValidator.validate(money);
        int[] moneyIntValues = getMoneyIntValues();
        Integer[] moneys = new Integer[NUMBER_OF_CURRENCY_TYPE];

        for (int i = 0; i < NUMBER_OF_CURRENCY_TYPE; i++) {
            moneys[i] = money/moneyIntValues[i];
            money %= moneyIntValues[i];
        }

        return Arrays.asList(moneys);
    }

    private int[] getMoneyIntValues() {
        return Arrays.stream(Money.values())
                .mapToInt(Money::getIntValue)
                .toArray();
    }
}
