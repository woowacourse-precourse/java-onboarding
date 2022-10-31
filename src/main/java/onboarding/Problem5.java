package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {

    private static final List<Integer> list = new ArrayList<>();
    private static int[] unitArr = new int[] { 50_000, 10_000, 5000, 1000, 500, 100, 50, 10, 1};


    public static List<Integer> solution(int money) {

        list.clear();

        for (int i = 0; i < unitArr.length; i++) {
            money = calcUnit(money, unitArr[i]);
        }

        return list;
    }

    public static int calcUnit(int money, int unit) {
        if (money < unit) {
            list.add(0);
        }
        else {
            list.add(countUnit(money, unit));
        }

        return money % unit;
    }

    public static int countUnit(int money, int unit) {
        return money / unit;
    }
}
