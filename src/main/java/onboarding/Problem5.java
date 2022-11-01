package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    private static final int[] bills = { 50_000, 10_000, 5_000, 1_000, 500, 100, 50, 10, 1 };

    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();

        for (int bill : bills) {
            int billCount = countBill(money, bill);
            answer.add(billCount);
            money = exchangeBill(money, billCount, bill);
        }

        return answer;
    }

    private static int countBill(int money, int bill) {
        return money / bill;
    }

    private static int exchangeBill(int money, int billCount, int bill) {
        return money - billCount * bill;
    }
}
