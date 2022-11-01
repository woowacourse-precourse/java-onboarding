package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    private static List<Integer> moneyTypes = List.of(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1);
    public static List<Integer> solution(int money) {
        return calculateLeastRequiredQuantity(money);
    }

    private static List<Integer> calculateLeastRequiredQuantity(int money) {
        List<Integer> moneyCounts = new ArrayList<Integer>();
        for (int i = 0; i < moneyTypes.size(); i++) {
            moneyCounts.add(money / moneyTypes.get(i));
            money %= moneyTypes.get(i);
        }
        return moneyCounts;
    }
}
