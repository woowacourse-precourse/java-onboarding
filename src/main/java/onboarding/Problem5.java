package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    public static final int UNIT_COUNT = 9;
    public static int[] units;

    public static List<Integer> solution(int money) {
        initUnit();

        return atm(money);
    }

    public static void initUnit() {
        units = new int[UNIT_COUNT];

        units[0] = 50000;
        units[1] = 10000;
        units[2] = 5000;
        units[3] = 1000;
        units[4] = 500;
        units[5] = 100;
        units[6] = 50;
        units[7] = 10;
        units[8] = 1;
    }

    public static List<Integer> atm(int money) {
        List<Integer> result = new ArrayList<>();

        for (int unit : units) {
            result.add(money / unit);
            money %= unit;
        }

        return result;
    }
}