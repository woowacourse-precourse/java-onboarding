package onboarding;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ExchangeUtils {

    private static final int FIFTY_THOUSAND = 50000;
    private static final int TEN_THOUSAND = 10000;
    private static final int FIVE_THOUSAND = 5000;
    private static final int ONE_THOUSAND = 1000;
    private static final int FIVE_HUNDRED = 500;
    private static final int ONE_HUNDRED = 100;
    private static final int FIFTY = 50;
    private static final int TEN = 10;
    private static final int ONE = 1;
    private static final int EXCHANGING_MONEY_SIZE = 9;

    public ExchangeUtils() {
    }

    public List<Integer> exchangeMoney(int money) {
        List<Integer> exchangingMoneyList = Arrays.asList(FIFTY_THOUSAND, TEN_THOUSAND, FIVE_THOUSAND, ONE_THOUSAND, FIVE_HUNDRED, ONE_HUNDRED, FIFTY, TEN, ONE);
        int[] exchangedMoneyArray = new int[EXCHANGING_MONEY_SIZE];
        int index = 0;
        while (money > 0) {
            if (money / exchangingMoneyList.get(index) > 0) {
                exchangedMoneyArray[index] = addExchangedMoneyCountToArray(money, exchangingMoneyList, index);
                money -= exchangingMoneyList.get(index) * exchangedMoneyArray[index++];
            } else {
                exchangedMoneyArray[index++] = 0;
            }
        }
        return Arrays.stream(exchangedMoneyArray).boxed().collect(Collectors.toList());
    }

    private int addExchangedMoneyCountToArray(int money, List<Integer> exchangingMoneyList, int index) {
        return money / exchangingMoneyList.get(index);
    }
}
