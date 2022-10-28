package onboarding;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Problem5 {
    private static final List<Integer> accountMoneys = Arrays.asList(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1);
    public static List<Integer> solution(int money) {
        return getMoneyInAccountMoneys(money);
    }

    private static List<Integer> getMoneyInAccountMoneys(int money) {
        int[] arr = new int[accountMoneys.size()];

        for(int i=0; i<accountMoneys.size(); i++) {
            arr[i] += money / accountMoneys.get(i);
            money %= accountMoneys.get(i);
        }
        return Arrays.stream(arr).boxed().collect(Collectors.toList());
    }
}
