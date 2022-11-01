package onboarding;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>(Collections.emptyList());
        int[] arr = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
        int idx = 0;

        for (int i = 0; i < 9; i++)
            answer.add(0);

        while (money > 0) {
            for (int i : arr) {
                while (money >= i) {
                    answer.set(idx, answer.get(idx) + 1);
                    money -= i;
                }
                idx++;
            }
        }


        return answer;
    }
}
