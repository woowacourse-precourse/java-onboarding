package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        return answer;
    }

    private static List<Integer> withdraw(int money) {
        List<Integer> result = new ArrayList<>();
        int[] units = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
        int remaining = money;

        for (int i = 0; i < units.length; i++) {
            int count = remaining / units[i];
            remaining %= units[i];
            result.add(count);
        }

        return result;
    }
}
