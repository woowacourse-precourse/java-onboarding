package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        int[] units = {50_000, 10_000, 5_000, 1_000, 500, 100, 50, 10, 1};
        List<Integer> result = new ArrayList<>(units.length);
        int count;

        for (int i = 0; i < units.length; i++) {
            count = money / units[i];
            result.add(count);
            money %= units[i];
        }

        return result;
    }
}
