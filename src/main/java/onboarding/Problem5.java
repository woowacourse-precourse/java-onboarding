package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    static int[] monetaryUnit = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

    public static List<Integer> getCvtArr(int money) {
        List<Integer> cvtArr = new ArrayList<>();
        for(int unit: monetaryUnit) {
            cvtArr.add(money / unit);
            money %= unit;
        }
        return cvtArr;
    }

    public static List<Integer> solution(int money) {
        return getCvtArr(money);
    }
}
