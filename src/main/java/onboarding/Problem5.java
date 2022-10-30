package onboarding;

import java.util.Arrays;
import java.util.List;

public class Problem5 {
    static final int[] currencyArr = new int[] {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

    public static List<Integer> solution(int money) {
        List<Integer> countList = getChangedCntList(money);

        return countList;
    }

    static List<Integer> getChangedCntList(int money) {
        List<Integer> countList = Arrays.asList(0,0,0,0,0,0,0,0,0);

        setCountList(money, currencyArr, countList);

        return countList;
    }

    static void setCountList(int money, int[] currencyArr, List<Integer> countList) {
        int len = currencyArr.length;

        for (int i = 0; i < len; i++) {
            int count = getCount(money, currencyArr[i]);

            money = deductMoney(money, currencyArr[i], count);
            countList.set(i, count);
        }
    }

    static int getCount(int money, int currency) {
        if (money >= currency) {
            return money / currency;
        }

        return 0;
    }

    static int deductMoney(int money, int currency, int count) {
        return money - (count * currency);
    }
}
