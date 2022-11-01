package onboarding;

import java.util.LinkedList;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        int[] MONEY = {50_000, 10_000, 5_000, 1_000, 500, 100, 50, 10, 1};

        LinkedList<Integer> result = new LinkedList<>();
        for (int m : MONEY) {
            int moneyCount = money / m;
            if (moneyCount >= 1) {
                result.add(moneyCount);
                money = money - m * moneyCount;
            } else {
                result.add(0);
            }
        }
        return result;
    }
}
