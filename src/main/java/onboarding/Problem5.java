package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        return change(money);
    }

    public static List<Integer> change(int money) {
        List<Integer> coins = new ArrayList<>(List.of(50_000, 10_000, 5_000, 1_000, 500, 100, 50, 10, 1));
        List<Integer> wallet = new ArrayList<>();
        for (int coin : coins) {
            wallet.add(money / coin);
            money %= coin;
        }
        return wallet;
    }
}
