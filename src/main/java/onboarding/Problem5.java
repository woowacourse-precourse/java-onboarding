package onboarding;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Problem5 {
    public static List<Integer> solution(int money) {

        int[] check = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
        int[] ans = new int[9];

        for (int i = 0; i < check.length; i++) {
            ans[i] = money / check[i];
            money %= check[i];
        }

        return Arrays.stream(ans).boxed().collect(Collectors.toList());
    }
}
