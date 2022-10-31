package onboarding;

import java.util.Collections;
import java.util.List;

public class Problem5 {
    private static final Integer[] PRICE = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        return answer;
    }

    private static void findNumberOfMoney(int money, List<Integer> answer) {
        for (Integer price : PRICE) {
            answer.add(money / price);
            money %= price;
        }
    }
}
