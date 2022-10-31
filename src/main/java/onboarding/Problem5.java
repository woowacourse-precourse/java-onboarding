package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        int[] units = {50_000, 10_000, 5_000, 1_000, 500, 100, 50, 10, 1};
        List<Integer> answer = new ArrayList<>(units.length);
        int count;

        for (int i = 0; i < units.length; i++) {
            count = money / units[i];
            answer.add(count);
            money %= units[i];
        }

        return answer;
    }
}
