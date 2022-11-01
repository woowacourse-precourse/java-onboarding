package onboarding;

import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new java.util.ArrayList<>(Collections.emptyList());
        int[] exchange = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

        for (int i = 0; i < exchange.length; i++) {
            int quotient = money / exchange[i];
            if (quotient > 0) {
                answer.add(quotient);
                money %= exchange[i];
            }else{
                answer.add(quotient);
            }
        }


        return answer;
    }
}
