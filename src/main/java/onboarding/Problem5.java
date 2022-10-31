package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
//        List<Integer> answer = Collections.emptyList();
        int[] answer = new int[9];
        int[] change = new int[]{50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

        for (int i = 0; i < change.length; i++) {
            if (i == 0) {
                answer[i] = (money / change[i]);
            } else {
                answer[i] = (money % change[i - 1]) / change[i];
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int element : answer) {
            result.add(element);
        }

        return result;
    }
}
