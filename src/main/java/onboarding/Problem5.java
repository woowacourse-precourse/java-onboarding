package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        check1(money);
        List<Integer> answer = new ArrayList<>();
        int[] divide = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

        for (int i = 0; i < divide.length; i++) {
            answer.add(money/divide[i]);
            money %= divide[i];

        }

        return answer;
    }
    public static void check1(int money) throws IllegalArgumentException{
        if (money < 1 || money > 1000000) {
            throw new IllegalArgumentException("money가 1보다 작거나 1000000을 초과했다.");
        }

    }
}
