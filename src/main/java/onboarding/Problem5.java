package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    static List<Integer> moneyPerUnitCounts = new ArrayList<>();

    public static List<Integer> solution(int money) {

        return moneyPerUnitCounts;
    }

    private static int giveChange(int money, int moneyPerUnit) {
        return money % moneyPerUnit;
    }
}
