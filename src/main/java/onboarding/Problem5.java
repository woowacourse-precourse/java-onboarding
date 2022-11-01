package onboarding;

import java.util.Collections;
import java.util.List;

public class Problem5 {

    private static final int[] Money = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

    public static List<Integer> solution(int money) {
        List<Integer> answer = new java.util.ArrayList<>(Collections.emptyList());

        while (money != 0) {
            for (int M : Money){
                answer.add(money / M);
                money %= M;
            }
        }

        return answer;
    }
}
