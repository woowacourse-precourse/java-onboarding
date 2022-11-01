package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Problem5 {

    private static final int MIN_MONEY = 1;
    private static final int MAX_MONEY = 1000000;
    private static final int[] availMoneyList = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

    public static List<Integer> solution(int money) {
        validateMoney(money);
        return getLeastMoneyList(money);
    }

    private static void validateMoney(int money) throws IllegalArgumentException {
        if (!isValidMoneyRange(money)) {
            throw new IllegalArgumentException(String.format("올바른 범위의 값은 %d - %d입니다.", MIN_MONEY, MAX_MONEY));
        }
    }

    private static boolean isValidMoneyRange(int money) {
        return (MIN_MONEY <= money) && (money <= MAX_MONEY);
    }

    private static List<Integer> getLeastMoneyList(int money) {
        List<Integer> list = makeEmptyMoneyList();

        for (int i = 0; i < availMoneyList.length; i++) {
            int currentMoney = availMoneyList[i];

            list.add(i, money / currentMoney);
            money %= currentMoney;
        }
        return list;
    }

    private static List<Integer> makeEmptyMoneyList() {
        return new ArrayList<>(availMoneyList.length);
    }
}
