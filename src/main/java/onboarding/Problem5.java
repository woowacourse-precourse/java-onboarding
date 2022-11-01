package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem5 {
    public static List<Integer> solution(int money) {
        Problem5 p5 = new Problem5();
        return p5.convert(money);
    }

    private List<Integer> convert(int money) {
        int[] bill = new int[]{50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
        int[] result = new int[bill.length];

        for (int i = 0; i < bill.length; i++) {
            if (money >= bill[i]) {
                result[i] = money / bill[i];
                money %= bill[i];
            }
        }
        return Arrays.stream(result).boxed().collect(Collectors.toList());
    }
}
