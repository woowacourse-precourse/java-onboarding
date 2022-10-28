package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = changeMoney(money);
        return answer;
    }

    public static List<Integer> changeMoney(int money) {
        int[] exchangeMoneyList = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
        List<Integer> list = new ArrayList<Integer>();

        for (int exchangeMoney : exchangeMoneyList) {
            if (money / exchangeMoney != 0) {
                list.add(money / exchangeMoney);
                money %= exchangeMoney;
            } else {
                list.add(0);
            }
        }
        return list;
    }

}

