package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {

    private static List<Integer> divisors = List.of(50_000, 10_000, 5_000, 1_000, 500, 100, 50, 10, 1);

    public static List<Integer> solution(int money) {

        List<Integer> answer = new ArrayList<>();
        for (int divisor : divisors) {
            int dividend = getDividend(money, divisor);
            answer.add(dividend);
            money -= divisor * dividend;
        }
        return answer;
    }

    private static int getDividend(int money, int divisor) {
        return money / divisor;
    }

}
