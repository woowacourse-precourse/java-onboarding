package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    static class Money {
        int cost;

        Money(int cost) throws Exception {
            if (!isValidCost(cost)) {
                throw new Exception("Wrong cost");
            }
            this.cost = cost;
        }

        private boolean isValidCost(int cost) {
            return cost >= 1 && cost <= 1000_000;
        }
    }
    static int[] currency = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

    public static List<Integer> solution(int money) {
        Money m;
        try {
            m = new Money(money);
        } catch (Exception e) {
            return Collections.emptyList();
        }

        money = m.cost;
        return getResultList(money);
    }

    private static List<Integer> getResultList(int money) {
        List<Integer> result =  new ArrayList<>();
        for (int i = 0; i <currency.length ; i++) {
            int temp = money / currency[i];
            result.add(temp);
            money %= currency[i];
        }
        return result;
    }
}
