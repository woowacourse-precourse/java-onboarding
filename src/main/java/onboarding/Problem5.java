package onboarding;

import java.util.Collections;
import java.util.List;

public class Problem5 {
    static class Money{
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

    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        Money m;
        try {
            m = new Money(money);
        } catch (Exception e) {
            return answer;
        }

        money = m.cost;


        return answer;
    }
}
