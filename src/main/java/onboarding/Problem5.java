package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    private static final int NUMBER_UNITS = 9;
    private static final int FIFTY_THOUSAND_WON = 50000;
    private static final int TEN_THOUSAND_WON = 10000;
    private static final int FIVE_THOUSAND_WON = 5000;
    private static final int ONE_THOUSAND_WON = 1000;
    private static final int FIVE_HUNDRED_WON = 500;
    private static final int ONE_HUNDRED_WON = 100;
    private static final int FIFTY_WON = 50;
    private static final int TEN_WON = 10;
    private static final int ONE_WON = 1;

    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        answer = withdrawMoney(money);
        return answer;
    }

    public static int[] getMonetaryUnit() {
        int[] wonUnit = new int[NUMBER_UNITS];
        wonUnit[0] = FIFTY_THOUSAND_WON;
        wonUnit[1] = TEN_THOUSAND_WON;
        wonUnit[2] = FIVE_THOUSAND_WON;
        wonUnit[3] = ONE_THOUSAND_WON;
        wonUnit[4] = FIVE_HUNDRED_WON;
        wonUnit[5] = ONE_HUNDRED_WON;
        wonUnit[6] = FIFTY_WON;
        wonUnit[7] = TEN_WON;
        wonUnit[8] = ONE_WON;
        return wonUnit;
    }

    public static List<Integer> withdrawMoney(int money) {
        List<Integer> countPerUnit = new ArrayList<>();
        for (int unit : getMonetaryUnit()) {
            countPerUnit.add(money / unit);
            money %= unit;
        }
        return countPerUnit;
    }
}
