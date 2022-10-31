package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        int[] divide = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

        for (int i = 0; i < divide.length; i++) {
            answer.add(money/divide[i]);
            money %= divide[i];

        }

        return answer;
    }
}
