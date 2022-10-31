package onboarding;

import java.util.Collections;
import java.util.List;

public class Problem5 {

    static final int[] monetary = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        return answer;
    }

    static int calculateChange(int money, int count, int index) {
        if (count == 0) {
            return money;
        }

        return money % (monetary[index] * count);
    }
}
