package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {

        int[] cash = new int[]{50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
        List<Integer> result = new ArrayList<>();

        for (int bill : cash) {
            int count = 0;
            if (money >= bill) {
                count = money / bill;
                money %= bill;
            }
            result.add(count);
        }

        return result;

    }
}
