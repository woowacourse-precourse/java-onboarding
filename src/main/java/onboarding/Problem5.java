package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> account = new ArrayList<>();
        List<Integer> won = List.of(50_000, 10_000, 5_000, 1_000, 500, 100, 50, 10, 1);
        int index = 0;
        for (int i = 0; i < won.size(); i++) {
            account.add(money / won.get(index));
            money %= won.get(index++);
        }
        return account;
    }
}
