package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    static final int MIN_MONEY = 1;
    static final int MAX_MONEY = 1000000;
    static final List<Integer> ERROR = Collections.emptyList();
    static final int LIST_SIZE = 9;
    static final int[] CURRENCYS = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        if (!isValidInput(money)) {
            answer = ERROR;
            return answer;
        }
        answer = convertMoney(money);
        return answer;
    }

    private static List<Integer> convertMoney(int money) {
        List<Integer> changeList = new ArrayList<>(LIST_SIZE);

        for (int currency : CURRENCYS) {
            changeList.add(money / currency);
            money %= currency;
        }
        return changeList;
    }

    private static boolean isValidInput(int money) {
        return isValidRange(money);
    }

    private static boolean isValidRange(int money) {
        return money >= MIN_MONEY && money <= MAX_MONEY;
    }
}
