package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();

        int[] digit = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

        for (int i = 0; i < digit.length; i++) {
            if (money >= digit[i]) {
                int count = money / digit[i];
                answer.add(count);
                money %= digit[i];
            } else {
                answer.add(0);
            }
        }

        return answer;
    }
}
