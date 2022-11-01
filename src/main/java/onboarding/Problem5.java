package onboarding;

import java.util.*;

public class Problem5 {
    private static final int[] moneyItem = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
    public static List<Integer> solution(int money) {

        List<Integer> answer = calculateMoney(money);

        return answer;
    }

    private static List<Integer> calculateMoney(int money) {
        List<Integer> moneyCount = new ArrayList<>();

        for (int item : moneyItem) {
            int share = money / item;
            moneyCount.add(share);
            money %= item;
        }

        return moneyCount;
    }

}