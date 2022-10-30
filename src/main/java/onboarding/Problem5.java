package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();

        final int[] PAPERS = new int[] { 50000, 10000, 5000, 1000, 500, 100, 50, 10, 1 };

        for (int i = 0; i < PAPERS.length; i++) {
            answer.add(money / PAPERS[i]);
            money = money % PAPERS[i];
        }

        return answer;
    }
}
