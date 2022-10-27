package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        return convertMoney(money);
    }

    private static List<Integer> convertMoney(int money) {
        Integer[] moneyList = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
        Integer[] moneyCnt = {0, 0, 0, 0, 0, 0, 0, 0, 0};

        for (int i = 0; i < moneyList.length; i++) {
            if (money / moneyList[i] == 0) continue;
            moneyCnt[i] += money / moneyList[i];
            money %= moneyList[i];
        }

        List<Integer> ret = new ArrayList<>(Arrays.asList(moneyCnt));
        return ret;
    }
}
