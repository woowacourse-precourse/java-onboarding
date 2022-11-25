package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    private static final int[] units = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

    public static List<Integer> solution(int money) {
        return withdraw(money);
    }

    public static List<Integer> withdraw(int money) {
        List<Integer> moneyCnt = new ArrayList<>();

        for (int unit : units) {
            setMoneyCnt(moneyCnt, money, unit);
            money = getChange(money, unit);
        }

        return moneyCnt;
    }

    private static void setMoneyCnt(List<Integer> moneyCnt, int money, int unit) {
        moneyCnt.add(money / unit);
    }

    private static int getChange(int money, int unit) {
        return money % unit;
    }
}
