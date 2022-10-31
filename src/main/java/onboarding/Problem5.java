package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> result = new ArrayList<>();
        int[] unit = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

        for (int i = 0; i < 9; i++) {
            if (money / unit[i] >= 1) {
                result.add(money / unit[i]);
            }
            else {
                result.add(0);
            }
            money %= unit[i];
        }
        return result;
    }
}
