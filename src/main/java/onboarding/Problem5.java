package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    private static final int[] Money = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
    public static List<Integer> solution(int money) {
        return countBill(money);
    }
    private static List<Integer> countBill(int money) {
        List<Integer> bill = new ArrayList<>();
        for (int m : Money) {
            bill.add(money / m);
            money %= m;
        }
        return bill;
    }
}
