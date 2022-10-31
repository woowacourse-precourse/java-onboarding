package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    public static int count = 0;
    public static List<Integer> solution(int money) {

        int[] cash = new int[]{50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
        List<Integer> result = new ArrayList<>();

        for (int bill : cash) {
            count = 0;
            money = calculateMoney(money, bill);
            result.add(count);
        }
        return result;
    }
    public static int calculateMoney(int money, int bill) {
        if (money >= bill) {
            count = money / bill;
            money %= bill;
        }
        return money;
    }
}
