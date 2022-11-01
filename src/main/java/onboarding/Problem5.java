package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        Problem5 p5 = new Problem5();
        return p5.convert(money);
    }

    private List<Integer> convert(int money) {
        int[] bill = new int[]{50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < bill.length; i++) {
            if (money >= bill[i]) {
                result.add(money / bill[i]);
                money %= bill[i];
            } else {
                result.add(0);
            }
        }
        return result;
    }
}
