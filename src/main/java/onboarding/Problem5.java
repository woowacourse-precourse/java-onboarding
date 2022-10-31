package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        return getWonCountList(money);
    }

    private static List<Integer> getWonCountList(int money) {
        int[] unitsOfWon = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
        List<Integer> wonCountList = new ArrayList<>();

        for (int unit : unitsOfWon) {
            wonCountList.add(money / unit);
            money %= unit;
        }
        return wonCountList;
    }
}
