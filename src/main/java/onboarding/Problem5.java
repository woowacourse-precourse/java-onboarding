package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> wallet = new ArrayList<>();
        int[] unit = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

        for(int i=0; i<unit.length; i++) {
            wallet.add(convert(money, unit[i]));
            money = changes(money, unit[i]);
        }

        return wallet;
    }

    private static int changes(int money, int unit) {
        return money - (unit * convert(money, unit));
    }

    private static int convert(int money, int unit) {
        return money / unit;
    }
}
