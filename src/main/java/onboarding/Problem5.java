package onboarding;

import java.util.LinkedList;
import java.util.List;

public class Problem5 {
    private static List<Integer> money2billList(int money) {
        int[] bills = new int[]{50_000, 10_000, 5_000, 1_000, 500, 100, 50, 10};
        List<Integer> pocket = new LinkedList<>();
        for (int bill : bills) {
            pocket.add(money / bill);
            money %= bill;
        }
        pocket.add(money);
        return pocket;
    }

    public static List<Integer> solution(int money) {
        return money2billList(money);
    }
}
