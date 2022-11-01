package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {

    static int[] arr = new int[]{50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        for (int divisor : arr) {
            answer.add(money / divisor);
            money -= divisor * (money / divisor);
        }
        return answer;
    }
}
