package onboarding;

import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        return answer;
    }

    static int[] getMoneyConversion (int money) {
        int[] currencyArr = new int[] {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
        int[] countArr = new int[] {0,0,0,0,0,0,0,0,0};




        return countArr;
    }

    static void convertMoney(int money, int[] currencyArr, int[] countArr) {
        int len = currencyArr.length;
        for (int i = 0; i < len; i++) {

        }
    }

    static int getCount(int money, int currency) {
        if (money >= currency) {
            return money / currency;
        }

        return 0;
    }
}
