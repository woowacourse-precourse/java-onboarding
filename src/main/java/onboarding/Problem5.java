package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {

    private static final int MONEY_MIN = 1;
    private static final int MONEY_MAX = 1000000;
    private static final int[] MONEY_TYPE_LIST = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

    public static List<Integer> solution(int money) {
        if (!checkMoneyValueValid(money)) {
            throw new IllegalArgumentException("[error] 잘못된 money가 입력되었습니다.");
        }
        List<Integer> answer = changeMoneyToMoneyTypeCountList(money);
        return answer;
    }

    public static boolean checkMoneyValueValid(int money) {
        return MONEY_MIN <= money && money <= MONEY_MAX;
    }

    public static List<Integer> changeMoneyToMoneyTypeCountList(int money) {
        List<Integer> moneyTypeCountList = new ArrayList<>();
        for (int moneyType : MONEY_TYPE_LIST) {
            moneyTypeCountList.add(money / moneyType);
            money %= moneyType;
        }
        return moneyTypeCountList;
    }

}
