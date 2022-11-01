package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> monetaryUnitCounts = new ArrayList<>();
        findMonetaryUnitCounts(monetaryUnitCounts, money);
        return monetaryUnitCounts;
    }

    private static void findMonetaryUnitCounts(
        List<Integer> monetaryUnitCounts, int money) {
        int[] monetaryUnits = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
        for (int monetaryUnit : monetaryUnits) {
            int monetaryUnitCount = countMonetaryUnit(money, monetaryUnit);
            money = giveChange(money, monetaryUnit);
            monetaryUnitCounts.add(monetaryUnitCount);
        }
    }

    private static int countMonetaryUnit(int money, int monetaryUnit) {
        return money / monetaryUnit;
    }

    private static int giveChange(int money, int monetaryUnit) {
        return money % monetaryUnit;
    }
}
