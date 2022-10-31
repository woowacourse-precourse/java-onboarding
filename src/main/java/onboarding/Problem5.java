package onboarding;

import java.util.LinkedList;
import java.util.List;

public class Problem5 {
    private static final int[] UNIT_MONEY = {50_000,10_000,5_000,1_000,500,100,50,10,1};
    private static List<Integer> changeMoney(int money)
    {
        List<Integer> changedCount = new LinkedList<>();
        for (int unit : UNIT_MONEY) {
            changedCount.add(money / unit);
            money %= unit;
        }
        return changedCount;
    }
    public static List<Integer> solution(int money) {

        return changeMoney(money);
    }
}
