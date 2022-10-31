package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
//        List<Integer> answer = Collections.emptyList();
        List<Integer> answer = new ArrayList<>();
        int[] temp = {};
        int[] kinds = new int[]{50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
        int cur = money;
        for (int val: kinds) {
            int cnt = cur / val;
            cur = cur % val;
            answer.add(cnt);
        }
        return answer;
    }
}
