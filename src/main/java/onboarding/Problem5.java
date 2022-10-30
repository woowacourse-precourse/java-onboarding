package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    static int[] units = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        answer = new ArrayList<Integer>();
        for (int i = 0; i < 9; i++) {
            int dummy = (int)money / units[i];
            answer.add(dummy);
            money %= units[i];
        }

        return answer;
    }
}
