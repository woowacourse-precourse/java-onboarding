package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = doExchangeMoney(money);
        return answer;
    }

    public static List<Integer> doExchangeMoney(int money) {
        int[] exchangeMoneyList = {50_000, 10_000, 5000, 1000, 500, 100, 50, 10, 1};
        List<Integer> list = new ArrayList<>();

        for (int exchangeMoney : exchangeMoneyList) {
            money = exchangeAndSubtractMoney(money, exchangeMoney, list);
        }
        return list;
    }

    public static int exchangeAndSubtractMoney(int money, int exchangeMoney, List<Integer> list) {
        if (money / exchangeMoney != 0) {
            list.add(money / exchangeMoney);
            return money % exchangeMoney;
        }

        list.add(0);
        return money;
    }

}

