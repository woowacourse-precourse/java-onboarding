package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Problem5 {
    public static List<Integer> solution(int money) {
        int[] units = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

        int[] ans = new int[9];
        while (money != 0) {
            for (int i = 0; i < units.length; i++) {
                if (money < units[i]) continue;
                ans[i] += (money / units[i]);
                money %= units[i];
            }
        }

        List<Integer> answer = new ArrayList<Integer>(Arrays.stream(ans).boxed().collect(Collectors.toList()));

        return answer;
    }
}
