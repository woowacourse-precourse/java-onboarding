package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {

    private static final int MONEY_MIN = 1;
    private static final int MONEY_MAX = 1000000;
    private static final int[] MONEY_TYPE_LIST = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        return answer;
    }

    public static boolean checkMoneyValueValid(int money) {
        return MONEY_MIN <= money && money <= MONEY_MAX;
    }

    public static List<Integer> chageMoneyToMoneyTypeCountList(int money) {
        List<Integer> moneyTypeCountList = new ArrayList<>();
        for (int moneyType : MONEY_TYPE_LIST) {
            moneyTypeCountList.add(money / moneyType);
            money %= moneyType;
        }
        return moneyTypeCountList;
    }

}
