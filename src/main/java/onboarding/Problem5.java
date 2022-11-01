package onboarding;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Problem5 {
    private static int calculateQuotient(int money, int bill) {
        return money / bill;
    }
    private static int calculateRemainder(int money, int bill) {
        return money % bill;
    }
    public static List<Integer> solution(int money) {
        List<Integer> answer = new LinkedList<>();
        int[] bills = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
        for (int bill : bills) {
            int numberOfBill = calculateQuotient(money, bill);
            int leftMoney = calculateRemainder(money, bill);
            answer.add(numberOfBill);
            money = leftMoney;
        }
        return answer;
    }
}
