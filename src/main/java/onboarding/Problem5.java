package onboarding;

import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        int[] result = new int[9];
        int[] unit = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

        for (int i = 0; i < 9; i++) {
            if (money / unit[i] >= 1) {
                result[i] = money / unit[i];
                money %= unit[i];
            }
        }
        return result;
    }
}
