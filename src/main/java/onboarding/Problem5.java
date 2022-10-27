package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static final int[] DIVISORS=new int[]{50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

    public static List<Integer> solution(int money) {
        ArrayList<Integer> answer = new ArrayList<>();

        for (int divisor : DIVISORS) {
            if (divisor > money)
                answer.add(0);

            if (divisor <= money)
                answer.add(money / divisor);

            money %= divisor;
        }

        return answer;
    }
}
