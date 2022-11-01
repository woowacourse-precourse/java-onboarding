package onboarding;

import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new java.util.ArrayList<>();
        int[] prices = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
        for (int price : prices) {
            if (money < price) {
                answer.add(0);
                continue;
            }
            answer.add(money / price);
            money %= price;
        }
        return answer;
    }
}
