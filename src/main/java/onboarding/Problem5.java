package onboarding;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Problem5 {
    private static final List<Integer> moneys = Arrays.asList(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1);
    public static List<Integer> solution(int money) {
        return getAccountMoneyInRange(money);
    }

    private static List<Integer> getAccountMoneyInRange(int money) {
        int[] arr = new int[moneys.size()];

        for(int i=0; i<moneys.size(); i++) {
            arr[i] += money / moneys.get(i);
            money %= moneys.get(i);
        }
        return Arrays.stream(arr).boxed().collect(Collectors.toList());
    }
}
