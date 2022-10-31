package onboarding;

import java.util.*;

public class Problem5 {

    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>(List.of(0, 0, 0, 0, 0, 0, 0, 0, 0));
        return answer;
    }

    private static List<Integer> findMoneyToUpdate(int money) {
        List<Integer> prices = List.of(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1);
        for (int price : prices) {
            if (money >= price) {
                int index = prices.indexOf(price);
                int count = money / price;
                return List.of(index, price, count);
            }
        }
        return List.of();
    }
}
